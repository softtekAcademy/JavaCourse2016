package com.softtek.academy.contact.controller;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.softtek.academy.contact.model.Person;
import com.softtek.academy.contact.storage.PersonStorage;

/**
 * Test class to verify {@link ContactRestController} functionality.
 * 
 * @author David.Hernandez
 */
public class ContactRestControllerTest {
	
	private String endPointURL;
	private final String APP_BASE_URL = "http://localhost:8080/ContractList";
	private final String API_MANAGE_CONTACTS = "/api/persons";
	
	private Person person;
	private RestTemplate restTemplate;
	
	
	@BeforeClass
	public static void init(){
			
		PersonStorage.create(new Person(0L, "Name Zero", "Alias Zero"));
		PersonStorage.create(new Person(1L, "Name One", "Alias One"));
	}
	
	
	@Before
	public void start(){
		
		endPointURL = APP_BASE_URL + API_MANAGE_CONTACTS;
		
		person = new Person();
		restTemplate = new RestTemplate();
	}
	
	
	@Test
	public void testCreateContact(){
		
		person.setName("David");
		person.setAlias("Hazek");
		person.setEmail("david.hernandezg@softtek.com");
		person.setPhoneNumber("(646)1627587");
		
		ResponseEntity<Person> personCreated = restTemplate.postForEntity(endPointURL, person, Person.class);
		System.out.println(personCreated);
	}
	
	@Test
	public void testReadContact(){
		endPointURL = APP_BASE_URL + API_MANAGE_CONTACTS + "/0";
		ResponseEntity<Person> personFound = restTemplate.getForEntity(endPointURL, Person.class);
		System.out.println(personFound);
	}
	
	@Test
	@SuppressWarnings("rawtypes")
	public void testReadAllContacts(){
		ResponseEntity<List> personsList = restTemplate.getForEntity(endPointURL, List.class);
		System.out.println("Persons list size: " +  personsList.getBody().size());
	}
	
	@Test
	public void testUpdateContact(){
		
		endPointURL = APP_BASE_URL + API_MANAGE_CONTACTS + "/1";
		
		Person updatePerson = new Person(1L, "Name is One-X now", "Alias is One-X now");
		restTemplate.put(endPointURL, updatePerson, Person.class);
	}

	@Test
	public void testDeleteContact(){
		
		endPointURL = APP_BASE_URL + API_MANAGE_CONTACTS + "/0";
		restTemplate.delete(endPointURL, person, Person.class);
	}
}
