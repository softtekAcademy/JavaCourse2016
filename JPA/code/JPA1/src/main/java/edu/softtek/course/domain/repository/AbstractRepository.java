package edu.softtek.course.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author benjamin.concha
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public abstract class AbstractRepository<Entity> {

	@Autowired(required = false)
	@Qualifier("taskExecutor")
	private ThreadPoolTaskExecutor taskExecutor;

	@PersistenceContext(unitName = "persistenceUnitH2")
	private EntityManager h2EntityManager;

	/**
	 * @return the contractEntityManager
	 */
	protected EntityManager getEntityManager() {
		return h2EntityManager;
	}

	public Entity save(final Entity entity) {
		h2EntityManager.persist(entity);
		return entity;
	}

	abstract List<Entity> getAll();

}
