package com.softtek.java.academy.soap.endpoint;

import javax.xml.transform.Source;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.ws.test.server.RequestCreator;
import org.springframework.ws.test.server.RequestCreators;
import org.springframework.ws.test.server.ResponseMatchers;
import org.springframework.xml.transform.StringSource;

/**
 * Unit test using MockWebServiceClient
 *
 */
@ContextConfiguration("classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BankEndpointTest {

	@Autowired
	private ApplicationContext applicationContext;

	private MockWebServiceClient mockWebServiceClient;
	
	@Before
	public void setUp() {
		mockWebServiceClient = MockWebServiceClient.createClient(applicationContext);
	}

	/**
	 * Successful call to service
	 */
	@Test
	public void testValidOrderRequest() {
		final Source requestPayload = new StringSource(
				"<bank:accountDetailsRequest xmlns:bank='http://www.academy-softtek.com/soap/bank'>"
						+ "<accountNumber>030889</accountNumber>"
						+ "<password>abc</password>"
				+ "</bank:accountDetailsRequest>");

		final Source responsePayload = new StringSource(
				"<bank:accountDetailsResponse xmlns:bank='http://www.academy-softtek.com/soap/bank'>"
						+ "<accountNumber>030889</accountNumber>"
						+ "<ownerFirstName>Jose Antonio</ownerFirstName>"
						+ "<ownerLastName>Hernandez Vazquez</ownerLastName>"
						+ "<amount>1000.0</amount>"
				+ "</bank:accountDetailsResponse>");

		final RequestCreator creator = RequestCreators.withPayload(requestPayload);
		
		mockWebServiceClient.sendRequest(creator).andExpect(ResponseMatchers.payload(responsePayload));
	}
	
	/**
	 * Unsuccessful call to service
	 */
	@Test
	public void testValidOrderRequestWrong() {
		final Source requestPayload = new StringSource(
				"<bank:accountDetailsRequest xmlns:bank='http://www.academy-softtek.com/soap/bank'>"
						+ "<accountNumber>123</accountNumber>"
						+ "<password>abc</password>"
				+ "</bank:accountDetailsRequest>");

		final Source responsePayload = new StringSource(
				"<SOAP-ENV:Fault xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/'>" +
						"<faultcode>SOAP-ENV:Server</faultcode>" +
						"<faultstring xml:lang='en'>Client not found.</faultstring>" +
				"</SOAP-ENV:Fault>");

		final RequestCreator creator = RequestCreators.withPayload(requestPayload);
		
		mockWebServiceClient.sendRequest(creator).andExpect(ResponseMatchers.payload(responsePayload));
	}
}
