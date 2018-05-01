package com.knauff.mike.serviceframework;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.knauff.mike.serviceframework.resources.CombatAircraft;
import com.knauff.mike.serviceframework.resources.SuperHero;
import com.knauff.mike.serviceframework.rest.RestSuperHeroResourceHandler;

@RunWith(SpringRunner.class)
/**
 * Used to create a simulated web environment and assign a random HTTP port:
 * 
 *	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
/**
 * Sets the active spring configuration profile for the tests
 */
@ActiveProfiles("dev")
/**
 * JUnit tests for the Service Framework
 *
 */
public class ServiceFrameworkApplicationTests {

	// Provides a simplified interface for REST communication with an HTTP
	// Server for the SuperHero Service
	//
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	/**
	 * Ensure that the application context can be loaded successfully
	 */
	@Test
	public void contextLoads() {
	}
	
	/**
	 * Ensure that the application content type is set correctly and
	 * resource is returned with the correct status code.
	 * 
	 */
	@Test
	public void testGetSuperHeroResource() {
		final String appJson = RestSuperHeroResourceHandler.APP_JSON;
		
		// Create the required headers and set the content type for the test
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", appJson);
		
		// Call the Super Hero Service and get a Super Hero Object 
		ResponseEntity<SuperHero> superHeroEntity =
				restTemplate.exchange("/my-app/resource/v0/superheroes/100",
						HttpMethod.GET, new HttpEntity<>(headers), SuperHero.class);
		
		// Make sure that the response was successful
		assertThat(superHeroEntity.getStatusCode(), is(HttpStatus.OK));
	}
	
	/**
	 * Ensure that the application content type is set correctly and
	 * resource is returned with the correct status code.
	 * 
	 */
	@Test
	public void testGetAircraftResource() {
		final String appJson = RestSuperHeroResourceHandler.APP_JSON;
		
		// Create the required headers and set the content type for the test
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", appJson);
		
		// Call the Super Hero Service and get a Super Hero Object 
		ResponseEntity<CombatAircraft> combatAircraftEntity =
				restTemplate.exchange("/my-app/resource/v0/aircraft/500",
						HttpMethod.GET, new HttpEntity<>(headers), CombatAircraft.class);
		
		// Make sure that the response was successful
		assertThat(combatAircraftEntity.getStatusCode(), is(HttpStatus.OK));
	}

}
