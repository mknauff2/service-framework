/**
 * 
 */
package com.knauff.mike.serviceframework.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @author mknauff
 *
 */
@ApplicationPath("/my-app")
@Component
public class JerseyConfig extends ResourceConfig {

	/**
	 * 
	 */
	public JerseyConfig() {
		// Resource handlers for the application
		// Rename or add application-specific resource handlers
		register(RestAppResourceHandler1.class);
		register(RestAppResourceHandler2.class);
		// Add other resource handlers here
		
	}

}
