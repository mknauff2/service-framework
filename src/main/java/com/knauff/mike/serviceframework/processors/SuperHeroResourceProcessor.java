/**
 * 
 */
package com.knauff.mike.serviceframework.processors;

import com.knauff.mike.serviceframework.resources.ISuperHero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.knauff.mike.serviceframework.resources.IGenericResource;

/**
 * Resource processor shell for handling resource CRUD requests. Needs to 
 * be heavily modified for an actual application and attached to a resource
 * source such as a database or other service that controls access to the actual
 * resource.
 * </br></br>
 * Default implementations just echo back what is sent in and needs to be
 * modified for the actual resource behavior.
 *  
 * @author mknauff
 *
 */
@Profile("dev")
@Component
public class SuperHeroResourceProcessor implements IGenericResourceProcessor<ISuperHero> {

	IGenericResource<ISuperHero> resource;
	
	/**
	 * 
	 */
	@Autowired
	public SuperHeroResourceProcessor(IGenericResource<ISuperHero> resource) {
		this.resource = resource;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.processors.IResourceProcessor#getResource(java.lang.String)
	 */
	@Override
	public ISuperHero getResource(String resourceId) {
		
		return this.resource.read(resourceId);
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.processors.IResourceProcessor#createResource(java.lang.Object)
	 */
	@Override
	public ISuperHero addUpdateResource(String resourceId) {
		return this.resource.create(resourceId);

	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.processors.IResourceProcessor#updateResource(java.lang.String)
	 */
	@Override
	public ISuperHero updateResource(String resourceId, ISuperHero resource) {
		
		return this.resource.update(resourceId, resource);
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.processors.IResourceProcessor#deleteResource(java.lang.String)
	 */
	@Override
	public ISuperHero deleteResource(String resourceId) {
		
		return this.resource.delete(resourceId);
	}
	
	

}
