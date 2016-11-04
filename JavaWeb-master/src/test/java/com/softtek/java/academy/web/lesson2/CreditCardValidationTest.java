/*
 * @(#) CreditCardValidationTest.java - 05/08/2015 
 *
 * Copyright 2015 Softtek. All Rights Reserved.
 */
package com.softtek.java.academy.web.lesson2;

import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import com.softtek.java.academy.web.lesson3.ShowXMLTest;

/**
 * Unit Test for <code>CreditCardValidation.html</code> and <code>CreditCardValidationServlet</code>
 * <br>
 * Analyze JSON response.
 *
 * @author luisf.robles
 */
public class CreditCardValidationTest {
	// ------------------
	// Static Properties
	// ------------------

	/** Instance to handle log message for current class. */
    private static final Logger logger = Logger.getLogger(ShowXMLTest.class);

	// -----------
	// Properties
	// -----------

	// -------------
	// Constructors
	// -------------

	// ----------------
	// Functionalities
	// ----------------

	/**
	 * setUp method.
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		setBaseUrl("http://localhost:9090/JavaWeb");
	}
    
	/**
	 * Analyze JSON response of <code>CreditCardValidationServlet</code>.
	 */
	@Test
	public void test() {
		beginAt("CreditCardValidation.html");	// http://localhost:9090/JavaWeb/CreditCardValidation.html
		
        assertTitleEquals("Credit Card Validation");
        
        assertSubmitButtonPresent("PostSubmit");
        setTextField("ccNumberParamPost","123456789012345678");
        setTextField("authNumberParamPost", "123");
        clickButton("PostSubmit");
        
        String pageContent = getPageSource();
        logger.info("Server Response: \n"+getServerResponse());

        Assert.assertTrue("Response expected success", pageContent.contains("Successful validation"));
	}

	// --------------------
	// Setters and Getters
	// --------------------
}
