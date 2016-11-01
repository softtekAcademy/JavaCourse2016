package com.softtek.academy.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softtek.academy.contact.model.Person;
import com.softtek.academy.contact.service.PersonManagerService;
import com.softtek.academy.contact.util.ActionResponse;

/**
 * This class defines a 'REST Controller' that writes object data directly to the HTTP response as JSON.
 * 
 * @author David.Hernandez
 */
@Controller
@RequestMapping("/api")
public class ContactRestController {

	@Autowired
	private PersonManagerService personManagerService;
	
	/**
	 * End-point related to CREATE a new 'Person' record.
	 * 
	 * @param (Person) person - Person representation.
	 * @return (ResponseEntity<ActionResponse>) - Response with operation related data.
	 */
	@RequestMapping(value = "/persons", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ActionResponse> createPerson(@RequestBody final Person person){
		
		System.out.println("Creating person in application...");
		
		ActionResponse actionResponse = new ActionResponse();
		boolean isSuccess = personManagerService.createPerson(person);
		
		actionResponse.setSuccess(isSuccess);
		
		if(isSuccess){
			actionResponse.setStatusCode(HttpStatus.CREATED);
			actionResponse.setMessage("Person was created successfully.");
			
		} else {
			actionResponse.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY);
			actionResponse.setMessage("Person could not be created due no information sent.");
		}
		
		return new ResponseEntity<ActionResponse>(actionResponse, (HttpStatus) actionResponse.getStatusCode());
	}
	
	
	/**
	 * End-point related to READ ALL 'Person' records available.
	 * 
	 * @param (Person) person - Person representation.
	 * @return (ResponseEntity<List<Person>>) - Response with operation related data.
	 */
	@RequestMapping(value = "/persons", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<Person>> obtainAllPersonsList(){
		
		System.out.println("Reading all persons saved in application...");
		
		List<Person> personList = personManagerService.readAll();
		return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
	}
	
	/**
	 * End-point related to READ a 'Person' record.
	 * 
	 * @param (Person) person - Person representation.
	 * @return (ResponseEntity<List<Person>>) - Response with operation related data.
	 */
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> obtainPerson(@PathVariable("id") final Long id){
		
		System.out.println("Reading person information in the application...");
		
		ResponseEntity<?> responseEntity;
		Person person = personManagerService.readPerson(id);
		
		if(person != null) {
			responseEntity = new ResponseEntity<Person>(person, HttpStatus.OK);
			
		} else {
			ActionResponse actionResponse = new ActionResponse();
			
			actionResponse.setSuccess(false);
			actionResponse.setStatusCode(HttpStatus.NOT_FOUND);
			actionResponse.setMessage("Person was not found");
			
			responseEntity = new ResponseEntity<ActionResponse>(actionResponse, actionResponse.getStatusCode());
		}
		
		return responseEntity;
	}
	
	
	/**
	 * End-point related to UPDATE 'Person' record.
	 * 
	 * @param (Person) person - Person representation.
	 * @return (ResponseEntity<ActionResponse>) - Response with operation related data.
	 */
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ActionResponse> updatePerson(@PathVariable("id") Long id,
			@RequestBody final Person person){
		
		System.out.println("Updating person in application...");
		
		ActionResponse actionResponse = new ActionResponse();
		Person updatedPerson = personManagerService.updatePersonById(id, person);
		
		if(updatedPerson != null){
			actionResponse.setSuccess(true);
			actionResponse.setXdata(updatedPerson);
			actionResponse.setStatusCode(HttpStatus.OK);
			actionResponse.setMessage(String.format("Person 'ID': %d was deleted succesfully.", id));
			
		} else {
			actionResponse.setSuccess(false);
			actionResponse.setXdata(null);
			actionResponse.setStatusCode(HttpStatus.NOT_FOUND);
			actionResponse.setMessage(String.format("Person 'ID': %d NOT exist.", id));
		}

		return new ResponseEntity<ActionResponse>(actionResponse, actionResponse.getStatusCode());
	}
	
	
	/**
	 * End-point related to DELETE 'Person' record specified.
	 * 
	 * @param (Person) person - Person representation.
	 * @return (ResponseEntity<ActionResponse>) - Response with operation related data.
	 */
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ActionResponse> deletePerson(@PathVariable("id") final Long id){
		
		System.out.println("Deleting person in application...");
		
		ActionResponse actionResponse = new ActionResponse();
		boolean isDeleted = personManagerService.deletePersonById(id);
		
		if(isDeleted){
			actionResponse.setSuccess(true);
			actionResponse.setStatusCode(HttpStatus.OK);
			actionResponse.setMessage(String.format("Person 'ID': %d was deleted succesfully.", id));
		} else {
			actionResponse.setSuccess(false);
			actionResponse.setStatusCode(HttpStatus.NOT_FOUND);
			actionResponse.setMessage(String.format("Person 'ID': %d NOT exist.", id));
		}
			
		return new ResponseEntity<ActionResponse>(actionResponse, (HttpStatus) actionResponse.getStatusCode());
	}
}
