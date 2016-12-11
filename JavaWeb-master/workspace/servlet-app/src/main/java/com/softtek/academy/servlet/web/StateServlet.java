package com.softtek.academy.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softtek.academy.servlet.domain.model.State;
import com.softtek.academy.servlet.service.StateService;

public class StateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = LoggerFactory.getLogger(WelcomeServlet.class);
	
	private StateService stateService;
	
	
	@Override
	public void init() throws ServletException {
		stateService = new StateService();
	}
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		WelcomeServlet.LOGGER.info("States Retrieved:");
		
		final List<State> states = stateService.list();		
		for (final State state : states) {
			WelcomeServlet.LOGGER.info("{}", state);
		}
		
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head><title>States</title></head>");
        out.println("<body>");
        
        out.println("	<h3>State List</h3>");
        
        out.println("	<table border='1' style='width: 40%'>");
        out.println("		<tr>");
        out.println("			<th width='20%'>Id</th>");
        out.println("			<th width='80%'>Description</th>");
        out.println("		</tr>");
        
        for (final State state : states) {
	        out.println("		<tr>");
	        out.println("			<td>" + state.getId() + "</td>");
	        out.println("			<td>" + state.getDescription() + "</td>");
	        out.println("		</tr>");
        }
        
        out.println("	</table>");
        
        out.println("	<br>");
        out.println("	<a href='/servlet-app/index.html'>Return to Index</a>");
        
        out.println("</body>");
        out.println("</html>");
    }
	
	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		final Long id = request.getParameter("id") != null ? new Long(request.getParameter("id").toString()) : 0L;
		final String description = 
				request.getParameter("description") != null 
				? request.getParameter("description").toString() : StringUtils.EMPTY;
		
		WelcomeServlet.LOGGER.info("Saving state: {} - {}", id, description);
		
		final State state = stateService.save(id, description);
		
				
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head><title>States</title></head>");
        out.println("<body>");
        
        out.println("	<h3>Added:</h3>");
        
        out.println("	id: " + state.getId() + "<br>");
        out.println("	Description: " + state.getDescription() + "<br>");
        
        out.println("	<br>");
        out.println("	<a href='/servlet-app/index.html'>Return to Index</a>");
        
        out.println("</body>");
        out.println("</html>");
    }

}