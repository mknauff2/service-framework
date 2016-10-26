/**
 * 
 */
package com.knauff.mike.serviceframework.resources;

/**
 * @author mknau
 *
 */
public class CombatAircraft implements IAircraft {
	
	private String resourceId;
	private String name;
	private String type;
	private String range;
	private String ceiling;
	private String maxSpeed;

	/**
	 * 
	 */
	public CombatAircraft() {
		super();
		this.type = "combat";
	}
	
	/**
	 * 
	 * @param resourceId
	 * @param name
	 * @param range
	 * @param ceiling
	 * @param maxSpeed
	 */
	public CombatAircraft(String resourceId, String name, String range, String ceiling, String maxSpeed) {
		this();
		this.resourceId = resourceId;
		this.name = name;
		this.range = range;
		this.ceiling = ceiling;
		this.maxSpeed = maxSpeed;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.IAircraft#getResourceId()
	 */
	@Override
	public String getResourceId() {
		
		return this.resourceId;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.IAircraft#getName()
	 */
	@Override
	public String getName() {
		
		return this.name;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.IAircraft#getType()
	 */
	@Override
	public String getType() {
		
		return this.type;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.IAircraft#getRange()
	 */
	@Override
	public String getRange() {
		
		return this.range;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.IAircraft#getCeiling()
	 */
	@Override
	public String getCeiling() {
		
		return this.ceiling;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.resources.IAircraft#getMaxSpeed()
	 */
	@Override
	public String getMaxSpeed() {
		
		return this.maxSpeed;
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
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(String range) {
		this.range = range;
	}
	
	/**
	 * @param ceiling the ceiling to set
	 */
	public void setCeiling(String ceiling) {
		this.ceiling = ceiling;
	}

	/**
	 * @param maxSpeed the maxSpeed to set
	 */
	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}	

}
