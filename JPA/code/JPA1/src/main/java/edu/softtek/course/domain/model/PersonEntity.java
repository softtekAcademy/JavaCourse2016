package edu.softtek.course.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class PersonEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String surname;

	@OneToMany(mappedBy = "personEntity", cascade = CascadeType.ALL)
	private List<ContractEntity> contracts;

	public PersonEntity() {
	}

	public PersonEntity(final String name, final String surname) {
		this.name = name;
		this.surname = surname;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the contracts
	 */
	public List<ContractEntity> getContracts() {
		if (contracts == null) {
			contracts = new ArrayList<ContractEntity>();
		}
		return contracts;
	}

	/**
	 * @param contracts
	 *            the contracts to set
	 */
	public void setContracts(List<ContractEntity> contracts) {
		this.contracts = contracts;
	}

	@Override
	public String toString() {
		return "PersonEntity [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}

}
