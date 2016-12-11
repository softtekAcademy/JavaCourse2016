/*
 * @(#) HelloWorldServletTest.java - 05/08/2015 
 *
 * Copyright 2015 Softtek. All Rights Reserved.
 */
package com.softtek.java.academy.web.lesson2;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Unit Test for <code>HelloWorldServlet</code>.
 *
 * @author luisf.robles
 */
@RunWith(PowerMockRunner.class)
public class HelloWorldServletTest {
	// ------------------
	// Static Properties
	// ------------------

	/** Instance to handle log message for current class. */
    private static final Logger logger = Logger.getLogger(HelloWorldServletTest.class);

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
	}

	/**
	 * Test Case for doPost() method.
	 * 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test 
	public void testDoPost() throws ServletException, IOException {
		HttpServletRequest req = PowerMockito.mock(HttpServletRequest.class);
		HttpServletResponse res = PowerMockito.mock(HttpServletResponse.class);
		
		HelloWorldServlet servlet = new HelloWorldServlet();
		
		StringWriter pageContent = new StringWriter();
		PowerMockito.when(res.getWriter())
        			.thenReturn(new PrintWriter(pageContent));
		
		// Calling Servlet by POST method.
		servlet.doPost(req, res);
		
	    logger.info("Content Type = " + res.getContentType());	    
	    logger.info("" + pageContent.toString());
	    
	    Assert.assertTrue("Check content page as Text/Plain", pageContent.toString().contains("Hello World!"));
	}

	// --------------------
	// Setters and Getters
	// --------------------
}
