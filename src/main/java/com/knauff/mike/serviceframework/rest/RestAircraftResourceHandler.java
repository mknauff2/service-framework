/**
 * 
 */
package com.knauff.mike.serviceframework.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

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
@Path("/resource/v0/aircraft")
public class RestAircraftResourceHandler {
	
	private IGenericResourceProcessor<IAircraft> processor;

	/**
	 * 
	 */
	public RestAircraftResourceHandler() {
		
		this.processor = new AircraftResourceProcessor();
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the requested resource
	 */
	@GET
	@Path("/{resource-id}")
	@Produces("text/json")
	public Response getResource(
			@PathParam("resource-id") String resourceId,
			@Context HttpHeaders httpHeaders) {
		
		IAircraft aircraft = this.processor.getResource(resourceId);
		return Response.ok(this.aircraftToJson(aircraft)).build();
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the new or updated resource
	 */
	@PUT
	@Path("/{resource-id}/{resource-state}")
	@Produces("text/jason")
	public Response putResource(
			@PathParam("resource-id") String resourceId,
			@PathParam("resource-state") String resourceState,
			@Context HttpHeaders httpHeaders) {
		
		IAircraft aircraft = this.processor.addUpdateResource(resourceId);
		return Response.ok(this.aircraftToJson(aircraft)).build();		
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the new or appended resource
	 */
	@POST
	@Path("/{resource-id}")
	@Consumes("application/json")
	@Produces("text/jason")
	public Response postResource(
			@PathParam("resource-id") String resourceId,
			String resource,
			@Context HttpHeaders httpHeaders) {
		
		IAircraft modResource = jsonToAircraft(resource);
		
		IAircraft aircraft = this.processor.updateResource(resourceId, modResource);
				
		return Response.ok(this.aircraftToJson(aircraft)).build();
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the resource that was deleted
	 */
	@DELETE
	@Path("/{resource-id}")
	@Produces("text/jason")
	public Response deleteResource(
			@PathParam("resource-id") String resourceId,
			@Context HttpHeaders httpHeaders) {
		
		IAircraft aircraft = this.processor.deleteResource(resourceId);
		return Response.ok(this.aircraftToJson(aircraft)).build();		
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
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	/**
	 * 
	 * @param jsonString
	 * @return an aircraft object or null if an error occurs
	 */
	private IAircraft jsonToAircraft(String jsonString) {
		IAircraft aircraft = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			aircraft = mapper.readValue(jsonString, CombatAircraft.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return aircraft;
	}

}
