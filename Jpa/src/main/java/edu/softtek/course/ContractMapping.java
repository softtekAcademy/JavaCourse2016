package edu.softtek.course;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.softtek.course.domain.model.ContractEntity;
import edu.softtek.course.domain.repository.ContractRepository;


public class ContractMapping {

	public static void main(String[] args) {
		String[] fileContext = { "META-INF/spring/applicationContext.xml", "META-INF/spring/jdbc-applicationContext.xml" };

		final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(fileContext);
		ContractRepository contractRepository = (ContractRepository) context.getBean("contractRepo");

		ContractEntity c1 = new ContractEntity(1l, false);
		ContractEntity c2 = new ContractEntity(2l, true);

		contractRepository.save(c1);
		contractRepository.save(c2);

		List<ContractEntity> contracts = contractRepository.getAll();
		for (ContractEntity contract : contracts) {
			System.out.println(contract);
		}
		context.close();
	}
}
