/**
 * 
 */
package com.knauff.mike.serviceframework.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knauff.mike.serviceframework.processors.AircraftResourceProcessor;
import com.knauff.mike.serviceframework.processors.IGenericResourceProcessor;
import com.knauff.mike.serviceframework.resources.CombatAircraft;
import com.knauff.mike.serviceframework.resources.IAircraft;

/**
 * Basic jaxrs shell for handling REST API requests needs to be heavily modified 
 * for the specific use case.
 * 
 * @author mknauff
 *
 */
@Component
@RestController
@RequestMapping("/my-app/resource/v0/aircraft")
public class RestAircraftResourceHandler {
	
	// Log initialization
	Logger logger = LoggerFactory.getLogger(RestSuperHeroResourceHandler.class);
	
	// The application content type
	public static final String APP_JSON = "application/json";
		
	// The specific type of resource processor
	private IGenericResourceProcessor<IAircraft> processor;

	// JSON message if the resource is not found
	private static final String NOT_FOUND = "{ Aircraft not found }";
		
	/**
	 * 
	 */
	@Autowired
	public RestAircraftResourceHandler(AircraftResourceProcessor processor) {
		
		this.processor = processor;
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the requested resource
	 */
	@RequestMapping(
			value="/{resourceId}",
			method=RequestMethod.GET,
			produces=APP_JSON)
	public ResponseEntity<String> getResource(
			@PathVariable String resourceId) {
		
		IAircraft aircraft = this.processor.getResource(resourceId);
		return responseHandler(aircraft, null);
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the new or updated resource
	 */
	@RequestMapping(
			value="/{resourceId}",
			method=RequestMethod.PUT,
			consumes=APP_JSON,
			produces=APP_JSON)
	public ResponseEntity<String> putResource(
			@PathVariable String resourceId,
			@RequestBody String resourceState) {
		
		IAircraft aircraft = this.processor.addUpdateResource(resourceId);
		return responseHandler(aircraft, null);		
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the new or appended resource
	 */
	@RequestMapping(
			value="/{resourceId}",
			method=RequestMethod.POST,
			consumes=APP_JSON,
			produces=APP_JSON)
	public ResponseEntity<String> postResource(
			@PathVariable String resourceId,
			@RequestBody String resource) {
		
		IAircraft modResource = jsonToAircraft(resource);
		
		IAircraft aircraft = this.processor.updateResource(resourceId, modResource);
				
		return responseHandler(aircraft, null);
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the resource that was deleted
	 */
	@RequestMapping(
			value="/{resourceId}",
			method=RequestMethod.DELETE,
			produces=APP_JSON)
	public ResponseEntity<String> deleteResource(
			@PathVariable String resourceId) {
		
		IAircraft aircraft = this.processor.deleteResource(resourceId);
		return responseHandler(aircraft, null);		
	}
	
	/**
	 * @param aircraft
	 * @param ex
	 * @return
	 */
	private ResponseEntity<String> responseHandler(final IAircraft aircraft, final Exception ex) {
		
		final String beginJsonMsg = "{ \"message\":\"";
		final String endJsonMsg = "\" }";
		
		if(aircraft == null && ex == null) {
			
			logger.debug("Aircraft not found!");
			return new ResponseEntity<>(beginJsonMsg + NOT_FOUND + 
					endJsonMsg, HttpStatus.NOT_FOUND);
			
		} else if(aircraft != null && ex == null) {
			logger.debug("Aircraft found!");
			return ResponseEntity.ok(aircraftToJson(aircraft));
			
		} else if(ex instanceof JsonMappingException) {
			logger.debug("ERROR 102: JSON Mapping Error!");
			return new ResponseEntity<>(beginJsonMsg + ex.getMessage() + 
					endJsonMsg, HttpStatus.BAD_REQUEST);
			
		} else {
			logger.debug("ERROR 999: Unknown Error!");
			logger.debug("Error Message: " + ex.getMessage());
			return new ResponseEntity<>(beginJsonMsg + ex.getMessage() + 
					endJsonMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 
	 * @param aircraft
	 * @return a formatted json object or null if an error occurs
	 */
	private String aircraftToJson(IAircraft aircraft) {
		String jsonString = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			jsonString = mapper.writeValueAsString(aircraft);
		} catch (Exception e) {
			logger.error("ERROR 100: Unable to convert object" + aircraft 
					+ " to JSON string", e);
		}
		
		return jsonString;
	}
	
	/**
	 * 
	 * @param jsonString
	 * @return a aircraft object or null if an error occurs
	 */
	private IAircraft jsonToAircraft(String jsonString) {
		IAircraft aircraft = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			aircraft = mapper.readValue(jsonString, CombatAircraft.class);
		} catch (Exception e) {
			logger.error("ERROR 101: Unable to convert JSON string" + jsonString 
					+ " to object " + aircraft, e);
		}
		
		return aircraft;
	}
	
}
