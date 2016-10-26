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

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knauff.mike.serviceframework.processors.IGenericResourceProcessor;
import com.knauff.mike.serviceframework.processors.SuperHeroResourceProcessor;
import com.knauff.mike.serviceframework.resources.ISuperHero;
import com.knauff.mike.serviceframework.resources.SuperHero;

/**
 * Basic jaxrs shell for handling REST API requests needs to be heavily modified 
 * for the specific use case.
 * 
 * @author mknauff
 *
 */
@Component
@Path("resource/v0/superheroes")
public class RestSuperHeroResourceHandler {

	private IGenericResourceProcessor<ISuperHero> processor;
	
	/**
	 * 
	 */
	public RestSuperHeroResourceHandler() {
		
		this.processor = new SuperHeroResourceProcessor();
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
		
		ISuperHero superHero = this.processor.getResource(resourceId);
		
		return Response.ok(superHeroToJson(superHero)).build();
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the new or updated resource
	 */
	@PUT
	@Path("/{resource-id}/{resource-state}")
	@Produces("text/json")
	public Response putResource(
			@PathParam("resource-id") String resourceId,
			@PathParam("resource-state") String resourceState,
			@Context HttpHeaders httpHeaders) {
		
		ISuperHero superHero = this.processor.addUpdateResource(resourceId);
		
		return Response.ok(superHeroToJson(superHero)).build();		
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
	@Produces("text/json")
	public Response postResource(
			@PathParam("resource-id") String resourceId,
			String resource,
			@Context HttpHeaders httpHeaders) {
		
		ISuperHero modResource = jsonToSuperHero(resource);
		
		ISuperHero superHero = this.processor.updateResource(resourceId, modResource);
		
		return Response.ok(superHeroToJson(superHero)).build();
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the resource that was deleted
	 */
	@DELETE
	@Path("/{resource-id}")
	@Produces("text/json")
	public Response deleteResource(
			@PathParam("resource-id") String resourceId,
			@Context HttpHeaders httpHeaders) {
		
		ISuperHero superHero = this.processor.deleteResource(resourceId); 
		return Response.ok(superHeroToJson(superHero)).build();		
	}
	
	/**
	 * 
	 * @param superHero
	 * @return a formatted json object or null if an error occurs
	 */
	private String superHeroToJson(ISuperHero superHero) {
		String jsonString = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			jsonString = mapper.writeValueAsString(superHero);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	/**
	 * 
	 * @param jsonString
	 * @return a superHero object or null if an error occurs
	 */
	private ISuperHero jsonToSuperHero(String jsonString) {
		ISuperHero superHero = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			superHero = mapper.readValue(jsonString, SuperHero.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return superHero;
	}

}
