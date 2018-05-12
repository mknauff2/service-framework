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
import com.knauff.mike.serviceframework.rest.RestAircraftResourceHandler;
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
	
	// Used for testing SuperHeroes
	private static final String heroBody = "{\"resourceId\":\"100\",\"name\":\"Superman\",\"secretIdentity\":\"Clark Kent\"," +
			"\"cityOfOperation\":\"Metrapolis\",\"comicCompany\":\"DC Comics\",\"superHeroGroup\":\"Justice League\","
			+ "\"isMetaHuman\":\"true\"}";
	
	// Used for testing Combat Planes
	private static final String planeBody = "{\"resourceId\":\"565\",\"name\":\"Raptor\",\"type\":\"combat\"," +
			"\"range\":\"1,839 miles\",\"ceiling\":\"60,000 ft\",\"maxSpeed\":\"1,498 mph\"}";

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
	 * the resource is successfully created and returned with the correct 
	 * status code.
	 * 
	 */
	@Test
	public void testPutSuperHeroResource() {
		final String appJson = RestSuperHeroResourceHandler.APP_JSON;
		
		// Create the required headers and set the content type for the test
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", appJson);
		
		// Create the record to send and create resource on the server
		HttpEntity<String> entity = new HttpEntity<>(heroBody, headers);
		
		
		// Call the Super Hero Service and get a Super Hero Object 
		ResponseEntity<SuperHero> superHeroEntity =
				restTemplate.exchange("/my-app/resource/v0/superheroes/100",
						HttpMethod.PUT, entity, SuperHero.class);
		
		// Make sure that the response was successful
		assertThat(superHeroEntity.getStatusCode(), is(HttpStatus.OK));
	}
	
	/**
	 * Ensure that the application content type is set correctly and
	 * the resource is successfully updated and returned with the correct 
	 * status code.
	 * 
	 */
	@Test
	public void testPostSuperHeroResource() {
		final String appJson = RestSuperHeroResourceHandler.APP_JSON;
		
		/**
		 * Create the required resource
		 * 
		 */
		
		// Create the required headers and set the content type for the test
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", appJson);
		
		// Create the record to send and create resource on the server
		HttpEntity<String> entity = new HttpEntity<>(heroBody, headers);
		
		
		// Call the Super Hero Service and get a Super Hero Object 
		ResponseEntity<SuperHero> superHeroEntity =
				restTemplate.exchange("/my-app/resource/v0/superheroes/100",
						HttpMethod.POST, entity, SuperHero.class);
		
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
		final String appJson = RestAircraftResourceHandler.APP_JSON;
		
		// Create the required headers and set the content type for the test
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", appJson);
		
		// Call the Aircraft Service and get a Combat Aircraft Object 
		ResponseEntity<CombatAircraft> combatAircraftEntity =
				restTemplate.exchange("/my-app/resource/v0/aircraft/500",
						HttpMethod.GET, new HttpEntity<>(headers), CombatAircraft.class);
		
		// Make sure that the response was successful
		assertThat(combatAircraftEntity.getStatusCode(), is(HttpStatus.OK));
	}
	
	/**
	 * Ensure that the application content type is set correctly and
	 * the resource is successfully created and returned with the correct 
	 * status code.
	 * 
	 */
	@Test
	public void testPutAircraftResource() {
		final String appJson = RestAircraftResourceHandler.APP_JSON;
		
		// Create the required headers and set the content type for the test
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", appJson);
		
		// Create the record to send and create resource on the server
		HttpEntity<String> entity = new HttpEntity<>(planeBody, headers);
		
		
		// Call the Aircraft Service and get a Combat Aircraft Object 
		ResponseEntity<CombatAircraft> aircraftEntity =
				restTemplate.exchange("/my-app/resource/v0/aircraft/500",
						HttpMethod.PUT, entity, CombatAircraft.class);
		
		// Make sure that the response was successful
		assertThat(aircraftEntity.getStatusCode(), is(HttpStatus.OK));
	}
	
	/**
	 * Ensure that the application content type is set correctly and
	 * the resource is successfully updated and returned with the correct 
	 * status code.
	 * 
	 */
	@Test
	public void testPostAircraftResource() {
		final String appJson = RestAircraftResourceHandler.APP_JSON;
		
		/**
		 * Create the required resource
		 * 
		 */
		
		// Create the required headers and set the content type for the test
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", appJson);
		
		// Create the record to send and create resource on the server
		HttpEntity<String> entity = new HttpEntity<>(planeBody, headers);
		
		
		// Call the Super Hero Service and get a Super Hero Object 
		ResponseEntity<CombatAircraft> aircraftEntity =
				restTemplate.exchange("/my-app/resource/v0/aircraft/500",
						HttpMethod.POST, entity, CombatAircraft.class);
		
		// Make sure that the response was successful
		assertThat(aircraftEntity.getStatusCode(), is(HttpStatus.OK));
				
	}

}
