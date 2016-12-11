/*
 * @(#) HelloWorldServlet.java - 05/08/2015 
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

/**
 * Servlet implementation class HelloWorldServlet
 *
 * @author luisf.robles
 */
public class HelloWorldServlet extends HttpServlet {
	// ------------------
	// Static Properties
	// ------------------

	/** <code>serialVersionUID</code>. */
	private static final long serialVersionUID = -370633685597428850L;
	/** Instance to handle log message for current class. */
    private static final Logger logger = Logger.getLogger(HelloWorldServlet.class);
	
	// -------------
	// Constructors
	// -------------
           
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
    }

	// ----------------
	// Functionalities
	// ----------------

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		logger.info("Processing HTTP Request - Get Method...");
		this.processRequest(pRequest, pResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		logger.info("Processing HTTP Request - Post Method...");
		this.processRequest(pRequest, pResponse);
	}
	
	/**
	 * Creation of Greeting message.
	 *
	 * @param pRequest		HTTP Request.
	 * @param pResponse     HTTP Response.
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequest(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		logger.debug("processRequest() - Start");
		
		pResponse.setContentType("text/html");
	    PrintWriter out = pResponse.getWriter();

	    out.println("<HTML>");
	    out.println(  "<HEAD>");
	    out.println(    "<TITLE>");
	    out.println(       "Greetings !!!");
	    out.println(    "</TITLE>");
	    out.println(  "</HEAD>");
	    out.println(  "<BODY>");	    
	    out.println(    "Hello World!");
	    out.println(  "</BODY>");
	    out.println("</HTML>");
	    out.flush();
		
		logger.debug("processRequest() - End");
	}

}
