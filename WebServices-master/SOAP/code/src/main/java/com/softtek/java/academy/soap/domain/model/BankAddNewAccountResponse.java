package com.softtek.java.academy.soap.domain.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "addNewAccountResponse", namespace = "http://www.academy-softtek.com/soap/bank")
@XmlType
public class BankAddNewAccountResponse {

	@XmlElement(required = true)
	private Boolean result;

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}
}
