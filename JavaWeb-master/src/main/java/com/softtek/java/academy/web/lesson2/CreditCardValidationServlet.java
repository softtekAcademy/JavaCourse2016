/*
 * @(#) CreditCardValidationServlet.java - 05/08/2015 
 *
 * Copyright 2015 Softtek. All Rights Reserved.
 */
package com.softtek.java.academy.web.lesson2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * Servlet implementation class CreditCardValidationServlet
 * 
 * @author luisf.robles
 */
public class CreditCardValidationServlet extends HttpServlet {
	// ------------------
	// Static Properties
	// ------------------

	/** <code>serialVersionUID</code>. */
	private static final long serialVersionUID = -2307391985858203572L;
	/** Instance to handle log message for current class. */
    private static final Logger logger = Logger.getLogger(CreditCardValidationServlet.class);
    
    /** <code>ccNumberParam</code> parameter. */
    private static final String CC_NUMBER_PARAM = "ccNumberParamPost";
    /** <code>authNumberParam</code> parameter. */
    private static final String AUTH_NUMBER_PARAM = "authNumberParamPost";
    /** <code>validationStatus</code>. */
    private static final String VALIDATION_STATUS = "validationStatus";

    /** <code>Success Validation</code> */
    private static final String OK_ERROR_MSG = "Successful validation";
    /** <code>Credit Card Error Message</code>. */
    private static final String CC_ERROR_MSG = "Credit Card Error, check value and retry again.";
    /** <code>Authorization Error Message</code>. */
    private static final String AUTH_ERROR_MSG = "Authorization Error, check value and retry again.";
    
	// -------------
	// Constructors
	// -------------
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditCardValidationServlet() {
        super();
    }

	// ----------------
	// Functionalities
	// ----------------

	/**
	 * Credit Card Validation <code>GET HTTP method</code>.
	 * <p/>
	 * Send message to resend request by <b>POST</b> method because Security.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		logger.debug("doGet() - Start");
		
		logger.info("Processing HTTP Request - Get Method...");
		
		pResponse.setContentType("text/plain");
	    PrintWriter out = pResponse.getWriter();

	    out.println("Response as [Text Plain]...");
	    out.println("Parameters are sensitive... so you have to send them by HTTP POST method.");
	    out.println("\nPlease avoid to send sensitive values in an URL (by HTTP GET method), for instance:");
	    out.println("http://localhost:9090/JavaWeb/CreditCardValidationServlet?ccNumberParamGet=123&authNumberParamGet=11");
	    out.println("\nGreetings.");
	    out.flush();
	    
	    logger.debug("doGet() - End");
	}

	/**
	 * Credit Card Validation <code>POST HTTP method</code>.
	 * <p/>
	 * <table border="1">
     *   <tr >
     *     <th>Parameter</th>
     *     <th>Description</th>
     *   </tr>
     *   <tr>
     *     <td>ccNumberParam</td>
     *     <td>Credit Card Number (18 digits)</td>
     *   </tr>
     *   <tr>
     *     <td>authNumberParam</td>
     *     <td>Authorization Number (3 digits)</td>
     *   </tr>
     * </table>
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		logger.debug("doPost() - Start");
		
		logger.info("Processing HTTP Request - Post Method...");
		
		String ccNumber   = pRequest.getParameter(CreditCardValidationServlet.CC_NUMBER_PARAM);
		String authNumber = pRequest.getParameter(CreditCardValidationServlet.AUTH_NUMBER_PARAM);
		logger.debug(CreditCardValidationServlet.CC_NUMBER_PARAM   + " = " + ccNumber);
		logger.debug(CreditCardValidationServlet.AUTH_NUMBER_PARAM + " = " + authNumber);
		
		
		pResponse.setContentType("application/json");
	    PrintWriter out = pResponse.getWriter();
	    
	  	//create Json Object
	    JSONObject json = new JSONObject();

	    // put some value pairs into the JSON object .
	    json.put(CreditCardValidationServlet.CC_NUMBER_PARAM  , ccNumber);
	    json.put(                            AUTH_NUMBER_PARAM, authNumber);
	    
	    String status = null;
	    if (ccNumber!=null && ccNumber.length()!=18) {
	    	status=CC_ERROR_MSG;
	    } else if (authNumber!=null && authNumber.length()!=3) {
	    	status=AUTH_ERROR_MSG;
	    } else {
	    	status=CreditCardValidationServlet.OK_ERROR_MSG;
	    }
	    json.put(VALIDATION_STATUS, status);
	    
	    
	    out.println(json.toString()); 
		out.flush();
		
		logger.debug("doPost() - End");
	}

}
