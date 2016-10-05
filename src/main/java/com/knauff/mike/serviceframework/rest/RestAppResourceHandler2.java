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

import com.knauff.mike.serviceframework.processors.IResourceProcessor;
import com.knauff.mike.serviceframework.processors.Resource2Processor;

/**
 * Basic jaxrs shell for handling REST API requests needs to be heavily modified 
 * for the specific use case.
 * 
 * @author mknauff
 *
 */
@Path("/resource/v0/resource2")
public class RestAppResourceHandler2 {
	
	private IResourceProcessor processor;

	/**
	 * 
	 */
	public RestAppResourceHandler2() {
		// TODO Auto-generated constructor stub
		this.processor = new Resource2Processor();
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the requested resource
	 */
	@GET
	@Path("/{resource-id}")
	@Produces("text/plain")
	public Response getResource1(
			@PathParam("resource-id") String resourceId,
			@Context HttpHeaders httpHeaders) {
		
		return Response.ok(this.processor.getResource(resourceId)).build();
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the new or updated resource
	 */
	@PUT
	@Path("/{resource-id}/{resource-state}")
	@Produces("text/plain")
	public Response putResource1(
			@PathParam("resource-id") String resourceId,
			@PathParam("resource-state") String resourceState,
			@Context HttpHeaders httpHeaders) {
		
		return Response.ok(this.processor.addUpdateResource(resourceId, resourceState)).build();		
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the new or appended resource
	 */
	@POST
	@Path("/{resource-id}")
	@Produces("text/plain")
	@Consumes("text/plain")
	public Response postResource(
			@PathParam("resource-id") String resourceId,
			String resource,
			@Context HttpHeaders httpHeaders) {
		
		return Response.ok(this.processor.updateResource(resourceId, resource)).build();
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param httpHeaders
	 * @return the response including the resource that was deleted
	 */
	@DELETE
	@Path("/{resource-id}")
	@Produces("text/plain")
	public Response deleteResource(
			@PathParam("resource-id") String resourceId,
			@Context HttpHeaders httpHeaders) {
		
		return Response.ok(this.processor.deleteResource(resourceId)).build();		
	}
	
	

}
