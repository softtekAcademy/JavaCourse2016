package com.softtek.java.academy.soap.domain.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Class representing XML response
 * 
 * @author JAHV
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="accountDetailsResponse", namespace="http://www.academy-softtek.com/soap/bank")
@XmlType
public class BankAccountResponse {

	@XmlElement(required = true)
	private String accountNumber;
	
	@XmlElement(required = true)
	private String ownerFirstName;
	
	@XmlElement(required = true)
	private String ownerLastName;
	
	@XmlElement(required = true)
	private Double amount;
	
	@XmlTransient
	private String password;
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the ownerFirstName
	 */
	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	/**
	 * @param ownerFirstName the ownerFirstName to set
	 */
	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}
	/**
	 * @return the ownerLastName
	 */
	public String getOwnerLastName() {
		return ownerLastName;
	}
	/**
	 * @param ownerLastName the ownerLastName to set
	 */
	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
		
}
