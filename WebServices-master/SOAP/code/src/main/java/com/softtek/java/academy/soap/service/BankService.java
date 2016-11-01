package com.softtek.java.academy.soap.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.softtek.java.academy.soap.domain.exception.BankException;
import com.softtek.java.academy.soap.domain.model.BankAccountResponse;
import com.softtek.java.academy.soap.domain.model.BankAddNewAccountResponse;

@Service
public class BankService {
	
	private Map<String, BankAccountResponse> users = new HashMap<String, BankAccountResponse>();
	
	public BankService() {
		final BankAccountResponse user1 = new BankAccountResponse();
		user1.setAccountNumber("030889");
		user1.setAmount(1000.00);
		user1.setOwnerFirstName("Jose Antonio");
		user1.setOwnerLastName("Hernandez Vazquez");
		user1.setPassword("abc");
		users.put(user1.getAccountNumber(), user1);
	}

	public BankAccountResponse getAccountDetails(final String account, final String password) throws Exception {
		final BankAccountResponse user = users.get(account);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		throw new BankException("Client not found.");
	}
	
	public BankAddNewAccountResponse addNewAccount(final String accountNumber, final String ownerFirstName, 
			final String ownerLastName, final String password, final Double amount) throws BankException {
		if(!users.containsKey(accountNumber)) {
			final BankAccountResponse newUser = new BankAccountResponse();
			newUser.setAccountNumber(accountNumber);
			newUser.setAmount(amount);
			newUser.setOwnerFirstName(ownerFirstName);
			newUser.setOwnerLastName(ownerLastName);
			newUser.setPassword(password);
			users.put(newUser.getAccountNumber(), newUser);
			
			final BankAddNewAccountResponse bankAddNewAccountResponse = new BankAddNewAccountResponse();
			bankAddNewAccountResponse.setResult(true);
			return bankAddNewAccountResponse;
		}
		throw new BankException("Client already exists.");
	}
}
