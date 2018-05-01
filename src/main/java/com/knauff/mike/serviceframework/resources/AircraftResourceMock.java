/**
 * 
 */
package com.knauff.mike.serviceframework.resources;

import org.springframework.stereotype.Component;

/**
 * @author mknau
 *
*/
@Component
public class AircraftResourceMock implements IGenericResource<IAircraft> {

	/**
	 * 
	 */
	public AircraftResourceMock() {
		// do nothing
	}

	@Override
	public IAircraft create(String resourceId) {
		return new CombatAircraft(
				resourceId,
				"Raptor",
				"1,839 miles",
				"60,000 ft",
				"1,498 mph"				
				);
	}

	@Override
	public IAircraft read(String resourceId) {
		
		return this.create(resourceId);
	}

	@Override
	public IAircraft update(String resourceId, IAircraft resource) {
		return resource;
	}

	@Override
	public IAircraft delete(String resourceId) {
		
		return this.create(resourceId);
	}
	
}
