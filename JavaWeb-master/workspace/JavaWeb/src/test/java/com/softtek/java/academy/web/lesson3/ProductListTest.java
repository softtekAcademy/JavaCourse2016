/*
 * @(#) ProductListTest.java - 06/08/2015 
 *
 * Copyright 2015 Softtek. All Rights Reserved.
 */
package com.softtek.java.academy.web.lesson3;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

/**
 * Unit Test for <code>ProductList.jsp</code>
 *
 * @author luisf.robles
 */
public class ProductListTest {

	// ------------------
	// Static Properties
	// ------------------

	/** Instance to handle log message for current class. */
    private static final Logger logger = Logger.getLogger(ProductListTest.class);
    
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
	 * Analyze if response of <code>ProductList.jsp</code> has content expected.
	 */
	@Test
	public void test() {
        beginAt("ProductList.jsp"); //http://localhost:9090/JavaWeb/ProductList.jsp
        
        logger.debug("HTML Response: \n" + getServerResponse());
        
        //Checking Title of the page.
        assertTitleEquals("Product List");
        
        // Checking some elements inside HTML response.
        assertElementPresentByXPath("//*[local-name()='table']//*[local-name()='th'][text()='Product ID']"); // Tile of column
        assertElementPresentByXPath("//*[local-name()='table']//*[local-name()='td'][text()='Product_3']");  // Product Name
	}
}
