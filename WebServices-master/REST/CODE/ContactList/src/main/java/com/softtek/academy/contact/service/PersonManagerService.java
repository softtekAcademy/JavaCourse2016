package com.softtek.academy.contact.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.softtek.academy.contact.model.Person;
import com.softtek.academy.contact.storage.PersonStorage;

/**
 * Service class related to all possible operations over a person.
 * @author David.Hernandez
 */
@Service
public class PersonManagerService {

	/**
	 * Service method that creates a new person.
	 * 
	 * @param (Person) person - 'Person' object to be saved.
	 * @return (boolean) - 'True' if 'Person' instance was created.
	 */
	public boolean createPerson(final Person person){
		
		boolean isCreated = false;
		
		if(person.getName().isEmpty()){
			return isCreated;
		} else {
			PersonStorage.create(person);
			isCreated = true;
		}
		
		return isCreated;
	}
	
	
	/**
	 * Service method that read a single person.
	 * 
	 * @param (Integer) person - Person 'ID' to search. 
	 * @return (Person) - 'Person' object read.
	 */
	public Person readPerson(final Long id){
		return ( PersonStorage.read(id) );
	}
	
	
	/**
	 * Service method that read all persons.
	 * 
	 * @return (List<Person>) - 'Person' list objects.
	 */
	public List<Person> readAll(){
		return ( PersonStorage.readAll() );
	}
	
	
	/**
	 * Service method that update a person.
	 * 
	 * @param (Integer) id - 'Person' ID.
	 * @return (Person) - 'Person' object that was updated.
	 */
	public Person updatePersonById(final Long id, final Person person){
		return ( PersonStorage.updateById(id, person) );
	}
	
	
	/**
	 * Service method that deletes a new person.
	 * 
	 * @param (Person) person - 'Person' object to be deleted.
	 * @return (boolean) - 'True' if 'Person' instance was deleted.
	 */
	public boolean deletePersonById(final Long idPerson){
		return ( PersonStorage.deleteById(idPerson) );
	}
	
}
