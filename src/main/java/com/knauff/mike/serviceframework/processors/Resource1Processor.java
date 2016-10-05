/**
 * 
 */
package com.knauff.mike.serviceframework.processors;

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
public class Resource1Processor implements IResourceProcessor {

	/**
	 * 
	 */
	public Resource1Processor() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.processors.IResourceProcessor#getResource(java.lang.String)
	 */
	@Override
	public String getResource(String resourceId) {
		// TODO Auto-generated method stub
		return resourceId;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.processors.IResourceProcessor#createResource(java.lang.Object)
	 */
	@Override
	public String addUpdateResource(String resourceId, String resourceState) {
		// TODO Auto-generated method stub
		return resourceId + " " + resourceState;

	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.processors.IResourceProcessor#updateResource(java.lang.String)
	 */
	@Override
	public String updateResource(String resourceId, String resource) {
		// TODO Auto-generated method stub
		return resourceId + " " + resource;
	}

	/* (non-Javadoc)
	 * @see com.knauff.mike.serviceframework.processors.IResourceProcessor#deleteResource(java.lang.String)
	 */
	@Override
	public String deleteResource(String resource) {
		// TODO Auto-generated method stub
		return resource;
	}
	
	

}
