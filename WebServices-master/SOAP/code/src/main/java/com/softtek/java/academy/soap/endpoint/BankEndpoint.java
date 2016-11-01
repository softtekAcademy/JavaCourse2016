package com.softtek.java.academy.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.Namespace;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.XPathParam;

import com.softtek.java.academy.soap.domain.model.BankAccountRequest;
import com.softtek.java.academy.soap.domain.model.BankAccountResponse;
import com.softtek.java.academy.soap.domain.model.BankAddNewAccountResponse;
import com.softtek.java.academy.soap.service.BankService;

/**
 * This marks the class as a special sort of @Component, suitable for handling
 * XML messages in Spring-WS, and also making it eligible for suitable for
 * component scanning.
 */
@Endpoint
public class BankEndpoint {

	private static final String NAME_SPACE = "http://www.academy-softtek.com/soap/bank";

	@Autowired
	private BankService bankService;

	/**
	 * The @PayloadRoot annotation tells Spring-WS that the request method is
	 * suitable for handling XML messages.
	 * localPart: Name of the payload root element handled by the annotated method.
	 * namespace: Namespace of the payload root element handled by the annotated method.
	 * 
	 * The @RequestPayload annotation indicates that the parameter should be
	 * mapped to the payload of the request message.
	 * 
	 * @ResponsePayload, indicating that the return value is used as the payload
	 * of the response message.
	 * 
	 * @param request
	 * @return
	 */
	@PayloadRoot(localPart = "accountDetailsRequest", namespace = NAME_SPACE)
	@ResponsePayload
	public BankAccountResponse getAccountDetails(@RequestPayload BankAccountRequest request) throws Exception {
		final BankAccountResponse response = bankService.getAccountDetails(
				request.getAccountNumber(), request.getPassword());
		return response;
	}
	
	
	/**
	 * Implementing Endpoint using XPath 
	 * 
	 * @param accountNumber
	 * @param ownerFirstName
	 * @param ownerLastName
	 * @param password
	 * @param amount
	 * @return
	 * @throws Exception
	 */
	@PayloadRoot(localPart = "addNewAccountRequest", namespace = NAME_SPACE)
	@Namespace(prefix = "bank", uri = NAME_SPACE)
	@ResponsePayload
	public BankAddNewAccountResponse getAccountDetails(@XPathParam("/bank:addNewAccountRequest/accountNumber") String accountNumber,
			@XPathParam("/bank:addNewAccountRequest/ownerFirstName") String ownerFirstName,
			@XPathParam("/bank:addNewAccountRequest/ownerLastName") String ownerLastName,
			@XPathParam("/bank:addNewAccountRequest/password") String password,
			@XPathParam("/bank:addNewAccountRequest/amount") Double amount) throws Exception {
		final BankAddNewAccountResponse response = bankService.addNewAccount(accountNumber, ownerFirstName, 
				ownerLastName, password, amount);
		return response;
	}
	
}
