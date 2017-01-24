package edu.softtek.course.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import edu.softtek.course.domain.model.ContractEntity;
import edu.softtek.course.domain.model.PersonEntity;
import edu.softtek.course.domain.repository.ContractRepository;
import edu.softtek.course.domain.repository.PersonRepository;


public class PersonContractService {

	@Autowired
	private PersonRepository personRepo;

	@Autowired
	private ContractRepository contractRepo;

	@PersistenceContext(unitName = "persistenceUnitH2")
	private EntityManager h2EntityManager;

	@Transactional
	public void addContractToPerson(PersonEntity person, final ContractEntity contract) {
		List<ContractEntity> contracts = new ArrayList<ContractEntity>();
		contracts.add(contract);
		person.setContracts(contracts);
		personRepo.save(person);

	}

}
