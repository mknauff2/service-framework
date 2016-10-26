/**
 * 
 */
package com.knauff.mike.serviceframework.resources;

/**
 * @author mknauff
 *
 */
public class SuperHero implements ISuperHero {
	
	private String resourceId;
	private String name;
	private String secretIdentity;
	private String cityOfOperation;
	private String comicCompany;
	private String superHeroGroup;
	private boolean isMetaHuman;

	/**
	 * 
	 */
	public SuperHero() {
		super();
		// do nothing
	}
	
	/**
	 * @param resourceId
	 * @param name
	 * @param secretIdentity
	 * @param cityOfOperation
	 * @param comicCompany
	 * @param superHeroGroup
	 * @param isMetaHuman
	 */
	public SuperHero(String resourceId, String name, String secretIdentity, String cityOfOperation, String comicCompany,
			String superHeroGroup, boolean isMetaHuman) {
		super();
		this.resourceId = resourceId;
		this.name = name;
		this.secretIdentity = secretIdentity;
		this.cityOfOperation = cityOfOperation;
		this.comicCompany = comicCompany;
		this.superHeroGroup = superHeroGroup;
		this.isMetaHuman = isMetaHuman;
	}

	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param secretIdentity the secretIdentity to set
	 */
	public void setSecretIdentity(String secretIdentity) {
		this.secretIdentity = secretIdentity;
	}

	/**
	 * @param cityOfOperation the cityOfOperation to set
	 */
	public void setCityOfOperation(String cityOfOperation) {
		this.cityOfOperation = cityOfOperation;
	}

	/**
	 * @param comicCompany the comicCompany to set
	 */
	public void setComicCompany(String comicCompany) {
		this.comicCompany = comicCompany;
	}

	/**
	 * @param superHeroGroup the superHeroGroup to set
	 */
	public void setSuperHeroGroup(String superHeroGroup) {
		this.superHeroGroup = superHeroGroup;
	}
	
	/**
	 * @param isMetaHuman the isMetaHuman to set
	 */
	public void setIsMetaHuman(boolean isMetaHuman) {
		this.isMetaHuman = isMetaHuman;
	}

	

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.ISuperHero#getResourceId()
	 */
	@Override
	public String getResourceId() {
		return this.resourceId;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.ISuperHero#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.ISuperHero#getSecretIdentity()
	 */
	@Override
	public String getSecretIdentity() {
		return this.secretIdentity;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.ISuperHero#getCityOfOperation()
	 */
	@Override
	public String getCityOfOperation() {
		return this.cityOfOperation;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.ISuperHero#getComicCompany()
	 */
	@Override
	public String getComicCompany() {
		return this.comicCompany;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.ISuperHero#getSuperHeroGroup()
	 */
	@Override
	public String getSuperHeroGroup() {
		return this.superHeroGroup;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.ISuperHero#isMetaHuman()
	 */
	@Override
	public boolean isMetaHuman() {
		return this.isMetaHuman;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SuperHero [resourceId=" + resourceId + ", name=" + name + ", secretIdentity=" + secretIdentity
				+ ", cityOfOperation=" + cityOfOperation + ", comicCompany=" + comicCompany + ", superHeroGroup="
				+ superHeroGroup + ", isMetaHuman=" + isMetaHuman + "]";
	}
	
	

}
