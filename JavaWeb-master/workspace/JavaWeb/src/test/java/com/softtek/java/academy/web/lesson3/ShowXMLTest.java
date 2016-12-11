/*
 * @(#) ShowXMLTest.java - 06/08/2015 
 *
 * Copyright 2015 Softtek. All Rights Reserved.
 */
package com.softtek.java.academy.web.lesson3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import org.apache.log4j.Logger;
import org.junit.Before;
//import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import org.custommonkey.xmlunit.*;

/**
 * Unit Test for <code>showXML.jsp</code>
 *
 * @author luisf.robles
 */
//@Ignore
public class ShowXMLTest extends XMLTestCase {
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

    /**
     * <code>Initialization Constructor</code>.
     *
     * @param pName
     */
    public ShowXMLTest(String pName) {
        super(pName);
    }
    
	// ----------------
	// Functionalities
	// ----------------

	/**
	 * setUp method.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		setBaseUrl("http://localhost:9090/JavaWeb");
	}

	/**
	 * Analyze if response of <code>ProductList.jsp</code> has content expected.
	 * 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	@Test
	public void test() throws SAXException, IOException {
        beginAt("showXML.jsp"); // http://localhost:9090/JavaWeb/showXML.jsp
        
        String serverResponse = getServerResponse();
        String pageSource     = getPageSource();
        logger.debug("HTML Response: \n" + serverResponse);
        logger.debug("Source Page  : \n" + pageSource);

        File filePath=new File("src/main/webapp/xml/showXML-Expected.xml");
        System.out.println(filePath.getAbsolutePath());
        FileReader expectedFile = null;
        
        StringReader actualXml = null;
        
        actualXml = new StringReader(pageSource);
        
        try{
        	expectedFile = new FileReader(filePath);
        } catch (Exception e) {
        	e.printStackTrace();
        	fail("Fail by exception [" + e.getMessage() + "]");
        }
        
        assertXMLEqual("Expected pieces to be similar", expectedFile, actualXml);
	}
	
	// --------------------
	// Setters and Getters
	// --------------------
}
