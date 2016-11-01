package com.softtek.academy.contact.storage;

import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.contact.model.Person;

/**
 * Stores a 'Person' information related.
 * 
 * @author David.Hernandez
 */
public class PersonStorage {

	// Stores personal data information.
	private static ArrayList<Person> personList = new ArrayList<Person>();

	// Stores 'ID' index used to identify a 'Person' internally.
	private static Long idIndex = personList.size() * 1L;
		
	/**
	 * Create a 'Person' at list.
	 * 
	 * @param (Person) person - Person data to save.
	 * @return (Person) - Person saved.
	 */
	public static Person create(Person person){
		if(person == null){
			person = new Person();
		}
		
		person.setId(idIndex++);
		PersonStorage.personList.add(person);
		
		return person;
	}
	
	
	/**
	 * Reads a 'Person' given its ID.
	 * 
	 * @param (Integer) id - Person 'ID'.
	 * @return (Person) - Person  data.
	 */
	public static Person read(final Long id){
		
		Person person = PersonStorage.findPersonById(id);
		return person;
	}
	
	/**
	 * Reads 'Person' list.
	 * 
	 * @param (Person) person - Person data to save.
	 * @return (Person) - Person saved.
	 */
	@SuppressWarnings("unchecked")
	public static List<Person> readAll(){
		
		ArrayList<Person> copyOfPersonList = 
				(ArrayList<Person>) PersonStorage.personList.clone();
		
		return copyOfPersonList;
	}
	
	
	/**
	 * Update a 'Person' at list.
	 * 
	 * @param (Integer) id - Person 'ID'.
	 * @return (Person) - Person updated.
	 */
	public static Person updateById(final Long id, final Person updatedPerson){
		
		Person originalPerson = PersonStorage.findPersonById(id);
		
		if(originalPerson == null){
			return null;
		}
		
		int indexPerson = PersonStorage.personList.indexOf(originalPerson);
		
		// Replaces 'Person' data and returns the element previously at the specified position. 
		originalPerson = PersonStorage.personList.set(indexPerson, updatedPerson);
		return originalPerson;
	}
	
	/**
	 * Delete a 'Person' from list by id.
	 * 
	 * @param (Integer) id - Person 'ID'.
	 * @return (boolean) - 'True' if was deleted successfully.
	 */
	public static boolean deleteById(final Long id){
		
		boolean isDeleted = false;
		Person person = PersonStorage.findPersonById(id);
		
		if(person == null){
			return isDeleted;
		}
		
		isDeleted = PersonStorage.personList.remove(person);
		
		return isDeleted;
	}
	
	
	/**
	 * Find a 'Person' by ID.
	 * 
	 * @param (Integer) id - ID of 'Person'
	 * @return (Person) - 'Person' object data.
	 */
	public static Person findPersonById(final Long id){
		
		for(Person person : PersonStorage.personList){
			if(person.getId() == id){
				return person;
			}
		}
		
		return null;
	}
}
