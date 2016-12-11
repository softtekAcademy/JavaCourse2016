package com.softtek.academy.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WelcomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = LoggerFactory.getLogger(WelcomeServlet.class);
	
	
	@Override
	public void init() throws ServletException {
		WelcomeServlet.LOGGER.info("Proccessing WelcomeServlet.init()");
	}	
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		final String currentTime = DateTime.now().toString();
				
		WelcomeServlet.LOGGER.info("Proccessing WelcomeServlet.doGet(): " + currentTime);
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head><title>Welcome</title></head>");
        out.println("<body>");
        
        out.println("	<h1>Welcome to my first Servlet</h1>");
        out.println("	<br><br>");
        out.println("	Current Date: " + currentTime);
        
        out.println("	<br>");
        out.println("	<a href='/servlet-app/index.html'>Return to Index</a>");
        
        out.println("</body>");
        out.println("</html>");
    }

}