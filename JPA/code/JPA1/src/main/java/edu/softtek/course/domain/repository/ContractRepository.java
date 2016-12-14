package edu.softtek.course.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.softtek.course.domain.model.ContractEntity;


/**
 * Abstract class for provide parallel pagination functionality over native
 * queries in progress DB
 * 
 * @author benjamin.concha
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ContractRepository {

	@Autowired(required = false)
	@Qualifier("taskExecutor")
	private ThreadPoolTaskExecutor taskExecutor;

	@PersistenceContext(unitName = "persistenceUnitH2")
	private EntityManager h2EntityManager;

	/**
	 * @return the contractEntityManager
	 */
	protected EntityManager getContractEntityManager() {
		return h2EntityManager;
	}

	public Long save(ContractEntity contract) {
		h2EntityManager.persist(contract);
		return contract.getId();
	}

	public List<ContractEntity> getAll() {
		return h2EntityManager.createQuery("SELECT C FROM ContractEntity C", ContractEntity.class).getResultList();
	}


}
