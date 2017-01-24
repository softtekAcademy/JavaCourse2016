package edu.softtek.course.domain.repository;

import java.util.List;

import edu.softtek.course.domain.model.PersonEntity;

/**
 * @author benjamin.concha
 */
public class PersonRepository extends AbstractRepository<PersonEntity> {

	public List<PersonEntity> getAll() {
		return getEntityManager().createQuery("SELECT p FROM PersonEntity p", PersonEntity.class).getResultList();
	}

	public PersonEntity find(final Long id) {
		return getEntityManager().find(PersonEntity.class, id);
	}


}
