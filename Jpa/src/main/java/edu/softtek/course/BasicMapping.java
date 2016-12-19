package edu.softtek.course;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.softtek.course.domain.model.PersonEntity;
import edu.softtek.course.domain.repository.PersonRepository;


public class BasicMapping {

	public static void main(String[] args) {
		String[] fileContext = { "META-INF/spring/applicationContext.xml", "META-INF/spring/jdbc-applicationContext.xml" };

		final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(fileContext);
		PersonRepository personRepo = (PersonRepository) context.getBean("personRepo");

		final PersonEntity p1 = new PersonEntity("name1", "surname1");
		final PersonEntity p2 = new PersonEntity("name2", "surname2");
		personRepo.save(p1);
		personRepo.save(p2);

		List<PersonEntity> persons = personRepo.getAll();
		for (PersonEntity person : persons) {
			System.out.println(person);
		}
		context.close();
	}
}
