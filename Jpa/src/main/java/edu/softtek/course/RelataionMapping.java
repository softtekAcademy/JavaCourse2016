package Jpa.src.main.java.edu.softtek.course;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import Jpa.src.main.java.edu.softtek.course.domain.model.ContractEntity;
import Jpa.src.main.java.edu.softtek.course.domain.model.PersonEntity;
import Jpa.src.main.java.edu.softtek.course.service.PersonContractService;

public class RelataionMapping {

	public static void main(String[] args) {

		String[] fileContext = { "META-INF/spring/applicationContext.xml",
				"META-INF/spring/jdbc-applicationContext.xml" };

		final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(fileContext);

		final PersonEntity p1 = new PersonEntity("name1", "surname1");
		ContractEntity contract = new ContractEntity(1l, false);
		System.out.println(p1);
		System.out.println("Before persist " + contract);
		final PersonContractService personService = (PersonContractService) context.getBean("personContractService");
		personService.addContractToPerson(p1, contract);
		System.out.println("After persist " + contract);

		context.close();
	}
}
