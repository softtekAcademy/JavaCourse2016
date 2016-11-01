package com.softtek.java.academy.soap.domain.model.marshaller;

import javax.xml.bind.annotation.XmlRegistry;

import com.softtek.java.academy.soap.domain.model.BankAccountRequest;
import com.softtek.java.academy.soap.domain.model.BankAccountResponse;

/**
 * Class to marshal XML responses for WebServiceTemplate
 * 
 * @XmlRegistry is used to mark a class that has XML annotations. To
 *              have your JAXB implementation process this class you need to
 *              ensure that it is included in the list of classes used to
 *              bootstrap the JAXBContext
 */
@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {
	}

	public BankAccountRequest createBankAccountRequest() {
		return new BankAccountRequest();
	}

	public BankAccountResponse createBankAccountResponse() {
		return new BankAccountResponse();
	}
}
