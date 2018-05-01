/**
 * 
 */
package com.knauff.mike.serviceframework.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.knauff.mike.serviceframework.resources.IAircraft;
import com.knauff.mike.serviceframework.resources.IGenericResource;

/**
 * @author mknauff
 *
 */
@Profile("dev")
@Component
public class AircraftResourceProcessor implements IGenericResourceProcessor<IAircraft> {

	IGenericResource<IAircraft> resource;
	
	/**
	 * 
	 */
	@Autowired
	public AircraftResourceProcessor(IGenericResource<IAircraft> resource) {
		
		this.resource = resource;
	}

	@Override
	public IAircraft getResource(String resourceId) {
		
		return this.resource.read(resourceId);
	}

	@Override
	public IAircraft addUpdateResource(String resourceId) {
		
		return this.resource.create(resourceId);
	}

	@Override
	public IAircraft updateResource(String resourceId, IAircraft resource) {
		
		return this.resource.update(resourceId, resource);
	}

	@Override
	public IAircraft deleteResource(String resourceId) {
		
		return this.resource.delete(resourceId);
	}

	
}
