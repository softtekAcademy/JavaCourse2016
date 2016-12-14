package edu.softtek.course.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author benjamin.concha
 * @since 17/09/2015
 *
 */
@Entity
@Table(name = "CONTRACT")
public class ContractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "CONTRACT_NUMBER", nullable = false)
	private Long contractNumber;

	@Column(name = "CONSORTIUM_FLAG", nullable = false)
	private boolean consortiumFlag;

	@ManyToOne
	@JoinColumn(name = "PERSON_ID", nullable = true)
	private PersonEntity personEntity;

	/**
	 * @param contractNumber
	 * @param consortiumFlag
	 */
	public ContractEntity() {
		super();
	}

	/**
	 * @param contractNumber
	 * @param consortiumFlag
	 */
	public ContractEntity(Long contractNumber, boolean consortiumFlag) {
		super();
		this.contractNumber = contractNumber;
		this.consortiumFlag = consortiumFlag;
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
	 * @return the contractNumber
	 */
	public Long getContractNumber() {
		return contractNumber;
	}

	/**
	 * @param contractNumber
	 *            the contractNumber to set
	 */
	public void setContractNumber(final Long contractNumber) {
		this.contractNumber = contractNumber;
	}

	/**
	 * @return the consortiumFlag
	 */
	public boolean isConsortiumFlag() {
		return consortiumFlag;
	}

	/**
	 * @param consortiumFlag
	 *            the consortiumFlag to set
	 */
	public void setConsortiumFlag(final boolean consortiumFlag) {
		this.consortiumFlag = consortiumFlag;
	}

	/**
	 * @return the personEntity
	 */
	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	/**
	 * @param personEntity
	 *            the personEntity to set
	 */
	public void setPersonEntity(final PersonEntity personEntity) {
		this.personEntity = personEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (consortiumFlag ? 1231 : 1237);
		result = prime * result + ((contractNumber == null) ? 0 : contractNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContractEntity other = (ContractEntity) obj;
		if (consortiumFlag != other.consortiumFlag)
			return false;
		if (contractNumber == null) {
			if (other.contractNumber != null)
				return false;
		} else if (!contractNumber.equals(other.contractNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContractEntity [id=" + id + ", contractNumber=" + contractNumber + ", consortiumFlag=" + consortiumFlag + "]";
	}

}
