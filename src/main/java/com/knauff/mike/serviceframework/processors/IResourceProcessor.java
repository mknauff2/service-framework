/**
 * 
 */
package com.knauff.mike.serviceframework.processors;

/**
 * Interface for common resource processors. Needs to be modified for use
 * by an actual application.
 * 
 * @author mknauff
 *
 */
public interface IResourceProcessor {
	
	/**
	 * Assumes that the operation is safe
	 * 
	 * @param resourceId of the resource to return
	 * @return a resource as a string
	 */
	String getResource(String resourceId);
	
	/**
	 * Assumes the resource is idempotent
	 * 
	 * @param resourceId of the resource to add or update
	 * @param resource is the resource value(s) represented as a string
	 * @return the new or updated resource as a string
	 */
	String addUpdateResource(String resourceId, String resource);
	
	/**
	 * May create a new resource or append new state to an existing resource.
	 * 
	 * Assumes that the resource is idempotent
	 * 
	 * @param resourceId the resource to create or append
	 * @param resource represented as a string to update
	 * @return the updated resource
	 */
	String updateResource(String resourceId, String resource);
	
	/**
	 * 
	 * @param resourceId of the resource to delete
	 * @return the deleted resource
	 */
	String deleteResource(String resourceId);

}
