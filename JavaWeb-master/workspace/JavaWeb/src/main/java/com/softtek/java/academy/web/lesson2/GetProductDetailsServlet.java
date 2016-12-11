/*
 * @(#) GetProductDetailsServlet.java - 05/08/2015 
 *
 * Copyright 2015 Softtek. All Rights Reserved.
 */
package com.softtek.java.academy.web.lesson2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.softtek.java.academy.web.lesson2.bean.ProductBean;

/**
 * Servlet implementation class GetProductDetailsServlet
 * 
 * @author luisf.robles
 */
public class GetProductDetailsServlet extends HttpServlet {
	// ------------------
	// Static Properties
	// ------------------

	/** <code>serialVersionUID</code>. */
	private static final long serialVersionUID = 5717697965140970839L;
	/** Instance to handle log message for current class. */
    private static final Logger logger = Logger.getLogger(GetProductDetailsServlet.class);
       
	// -------------
	// Constructors
	// -------------
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductDetailsServlet() {
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
		
		pResponse.setContentType("text/xml");
	    PrintWriter out = pResponse.getWriter();

	    ProductBean bean = this.dummyFactoryBean();
	    String xml = bean.toString();
	    out.println(xml);	    
	    out.flush();
	    
	    logger.info("Bean serialized as XML: \n" + xml);
		
		logger.debug("processRequest() - End");
	}
	
	/**
	 * Create a <b>Dummy instance</b> of a Product.
	 *
	 * @return <code>ProductBean</code> instance with hardcode values.
	 */
	private ProductBean dummyFactoryBean() {
		ProductBean bean = new ProductBean();
		
		bean.setProductId(123456789);
		bean.setProductName("Product Name Example");
		bean.setStock(850);
		bean.setPrice(190.50);
		bean.setExpiration(new Date());
		
		return bean;
	}
}
