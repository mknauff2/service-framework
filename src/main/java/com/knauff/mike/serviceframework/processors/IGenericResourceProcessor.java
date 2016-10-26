/**
 * 
 */
package com.knauff.mike.serviceframework.processors;

/**
 * @author mknauff
 *
 */
public interface IGenericResourceProcessor<T> {
	
	/**
	 * Assumes that the operation is safe
	 * 
	 * @param resourceId of the resource to return
	 * @return a resource
	 */
	T getResource(String resourceId);
	
	/**
	 * Assumes the resource is idempotent
	 * 
	 * @param resourceId of the resource to add or update
	 * @param resource is the resource value(s)
	 * @return the new or updated resource as a string
	 */
	T addUpdateResource(String resourceId);
	
	/**
	 * May create a new resource or append new state to an existing resource.
	 * 
	 * Assumes that the resource is idempotent
	 * 
	 * @param resourceId the resource to create or append
	 * @param resource represented as a superheor to update
	 * @return the updated resource
	 */
	T updateResource(String resourceId, T resource);
	
	/**
	 * 
	 * @param resourceId of the resource to delete
	 * @return the deleted resource
	 */
	T deleteResource(String resourceId);

}
