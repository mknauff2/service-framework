/**
 * 
 */
package com.knauff.mike.serviceframework.resources;

/**
 * @author mknauff
 *
 */
public interface IGenericResource<T> {
	
	public T create(String resourceId);
	
	public T read(String resourceId);
	
	public T update(String resourceId, T resource);
	
	public T delete(String resourceId);	

}
