package com.softtek.java.academy.soap.domain.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class representing XML request
 * 
 * @author JAHV
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "accountDetailsRequest", namespace = "http://www.academy-softtek.com/soap/bank")
@XmlType
public class BankAccountRequest {

	@XmlElement(required = true)
	private String accountNumber;

	@XmlElement(required = true)
	private String password;

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
