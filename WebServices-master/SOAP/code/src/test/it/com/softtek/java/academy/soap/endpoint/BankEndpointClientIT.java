package com.softtek.java.academy.soap.endpoint;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.w3c.dom.NodeList;

import com.softtek.java.academy.soap.domain.model.BankAccountRequest;
import com.softtek.java.academy.soap.domain.model.BankAccountResponse;

/**
 * Consuming WS using WebServiceTemplate
 *
 */
@ContextConfiguration("classpath:client-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BankEndpointClientIT {

	@Autowired
	private WebServiceTemplate wsTemplate;

	/**
	 * Successful call to service
	 */
	@Test
	public void consumeBankService() {
		final BankAccountRequest request = new BankAccountRequest();
		request.setAccountNumber("030889");
		request.setPassword("abc");

		final BankAccountResponse response = (BankAccountResponse) wsTemplate.marshalSendAndReceive(request);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getAccountNumber());
		Assert.assertNotNull(response.getOwnerFirstName());
		Assert.assertNotNull(response.getOwnerLastName());
		Assert.assertNotNull(response.getAmount());

		Assert.assertEquals(response.getAccountNumber(), "030889");
		Assert.assertEquals(response.getOwnerFirstName(), "Jose Antonio");
		Assert.assertEquals(response.getOwnerLastName(), "Hernandez Vazquez");
		Assert.assertEquals(response.getAmount(), (Double) 1000.00);
	}

	/**
	 * Unsuccessful call to service
	 */
	@Test(expected = SoapFaultClientException.class)
	public void consumeBankServiceWrong() {
		final BankAccountRequest request = new BankAccountRequest();
		request.setAccountNumber("123");
		request.setPassword("abc");

		wsTemplate.marshalSendAndReceive(request);
	}

	/**
	 * Consuming service using
	 * 
	 * @throws Exception
	 */
	@Test
	public void consumeUsingSaaj() throws Exception {

		// Create SOAP Connection
		final SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		final SOAPConnection soapConnection = soapConnectionFactory.createConnection();

		// Send SOAP Message to SOAP Server
		final String url = "http://localhost:8080/soap/ws/bank.wsdl";
		final SOAPMessage soapResponse = (SOAPMessage) soapConnection.
				call(createSOAPRequest("03088", "abc"), url);

		// print SOAP Response
		System.out.println("Response SOAP Message:");
		soapResponse.writeTo(System.out);
		System.out.println("");
		soapConnection.close();
		
		Assert.assertNotNull(soapResponse);
		Assert.assertNotNull(soapResponse.getSOAPBody());
		Assert.assertNotNull(soapResponse.getSOAPBody().getFirstChild());
		
		final Node first = (Node) soapResponse.getSOAPBody().getFirstChild();
		
		Assert.assertNotNull(first);
		
		final NodeList nodeList = first.getChildNodes();
		
		Assert.assertNotNull(nodeList);
		
		for(int i=0; i<nodeList.getLength(); i++) {
			final Node n = (Node) nodeList.item(i);
			final String value = n.getValue();
			Assert.assertNotNull(value);
		}
		
	}

	private static SOAPMessage createSOAPRequest(final String accountNumber, final String password) throws Exception {
		final MessageFactory messageFactory = MessageFactory.newInstance();
		final SOAPMessage soapMessage = messageFactory.createMessage();
		final SOAPPart soapPart = soapMessage.getSOAPPart();

		final String nameSpace = "http://www.academy-softtek.com/soap/bank";
		final String preffix = "bank";

		// SOAP Envelope
		final SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration(preffix, nameSpace);

		/*
		 * Constructed SOAP Request Message:
		 * 
		 * <SOAP-ENV:Envelope
		 * xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
		 * xmlns:bank="http://www.academy-softtek.com/soap/bank">
		 * 		<SOAP-ENV:Header/> <SOAP-ENV:Body> 
		 * 			<bank:accountDetailsRequest>
		 * 				<accountNumber>?</accountNumber> 
		 * 				<password>?</password>
		 * 			</bank:accountDetailsRequest> 
		 * 		</SOAP-ENV:Body> 
		 * </SOAP-ENV:Envelope>
		 */

		// SOAP Body
		final SOAPBody soapBody = envelope.getBody();

		final SOAPElement soapBodyElem = ((SOAPElement) soapBody).addChildElement("accountDetailsRequest", preffix);
		final SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("accountNumber");
		soapBodyElem1.addTextNode(accountNumber);
		final SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("password");
		soapBodyElem2.addTextNode(password);
		soapMessage.saveChanges();

		/* Print the request message */
		System.out.println("Request SOAP Message:");
		soapMessage.writeTo(System.out);
		System.out.println();

		return soapMessage;
	}

}
