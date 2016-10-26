/**
 * 
 */
package com.knauff.mike.serviceframework.processors;

import com.knauff.mike.serviceframework.resources.AircraftResourceMock;
import com.knauff.mike.serviceframework.resources.IAircraft;
import com.knauff.mike.serviceframework.resources.IGenericResource;

/**
 * @author mknauff
 *
 */
public class AircraftResourceProcessor implements IGenericResourceProcessor<IAircraft> {

	IGenericResource<IAircraft> resource;
	
	/**
	 * 
	 */
	public AircraftResourceProcessor() {
		
		this.resource = new AircraftResourceMock();
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
