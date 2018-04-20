/**
 * 
 */
package com.knauff.mike.serviceframework.resources;

import org.springframework.stereotype.Component;

/**
 * @author mknauff
 *
 */
@Component
public class SuperHeroResourceMock implements IGenericResource<ISuperHero> {

	/**
	 * 
	 */
	public SuperHeroResourceMock() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.IGenericResource#create(java.lang.String)
	 */
	@Override
	public ISuperHero create(String resourceId) {
		return new SuperHero(
				resourceId,
				"Superman",
				"Clark Kent",
				"Metrapolis",
				"DC Comics",
				"Justice League",
				true);
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.IGenericResource#read(java.lang.String)
	 */
	@Override
	public ISuperHero read(String resourceId) {
		
		return this.create(resourceId);
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.IGenericResource#update(java.lang.String, com.knauff.mike.serviceframework.resources.ISuperHero)
	 */
	@Override
	public ISuperHero update(String resourceId, ISuperHero superHero) {
		
		return superHero;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.IGenericResource#delete(java.lang.String)
	 */
	@Override
	public ISuperHero delete(String resourceId) {
		
		return this.create(resourceId);
	}

}
