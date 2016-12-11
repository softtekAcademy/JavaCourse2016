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

import com.softtek.academy.servlet.domain.model.City;
import com.softtek.academy.servlet.domain.model.State;
import com.softtek.academy.servlet.service.CityService;
import com.softtek.academy.servlet.service.StateService;

public class CityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = LoggerFactory.getLogger(CityServlet.class);
	
	private CityService cityService;
	private StateService stateService;
	
	
	@Override
	public void init() throws ServletException {
		cityService = new CityService();
		stateService = new StateService();
	}
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		response.setContentType("text/html");
        final PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head><title>Cities</title></head>");
        out.println("<body>");
        
		if (request.getParameter("cityId") == null) {
			this.printCityList(out);
		}
		else {
			this.printEditCity(out, new Long(request.getParameter("cityId").toString()));
		}		
        
        out.println("	<br>");
        out.println("	<a href='/servlet-app/index.html'>Return to Index</a>");
        
        out.println("</body>");
        out.println("</html>");
    }
	
	private void printCityList(final PrintWriter out) {
		CityServlet.LOGGER.info("Cities Retrieved:");
		
		final List<City> cities = cityService.list();		
		for (final City city : cities) {
			CityServlet.LOGGER.info("{}", city);
		}
        
        out.println("	<h3>City List</h3>");
        
        out.println("	<table border='1' style='width: 40%'>");
        out.println("		<tr>");
        out.println("			<th width='20%'>Id</th>");
        out.println("			<th width='40%'>Description</th>");
        out.println("			<th width='40%'>State</th>");
        out.println("		</tr>");
        
        for (final City city : cities) {
	        out.println("		<tr>");
	        out.println("			<td><a href='/servlet-app/cities?cityId=" + city.getId() + "'>" + city.getId() + "</a></td>");
	        out.println("			<td>" + city.getDescription() + "</td>");
	        out.println("			<td>" + city.getState().getDescription() + "</td>");
	        out.println("		</tr>");
        }
        
        out.println("	</table>");
	}
	
	private void printEditCity(final PrintWriter out, final Long cityId) {
		final City city = cityService.getOne(cityId);
		CityServlet.LOGGER.info("Update city: {}", city);
        
        out.println("	<h3>Update City</h3>");
    	
        out.println("	<form action='/servlet-app/cities' method='post'>");
        // hidden field to let doPost() know about update operation
        out.println("		<input type='hidden' name='update' value='true'>");  
        out.println("		Id: <input type=''text' name='id' value='" +  city.getId() + "' readonly><br>");
        out.println("		Description: <input type='text' name='description' value='" +  city.getDescription() + "'><br>");
        out.println("		State:");
        out.println("		<select name='stateId'>");
        out.println("			<option value='0' selected>- Select -</option>");
        
        for (State state : stateService.list()) {
        	final String selected = state.getId() == city.getState().getId() ? "selected" : StringUtils.EMPTY;
        	out.println("		<option value='" + state.getId() + "' " + selected + ">" + state.getDescription() + "</option>");
        }
        
        out.println("		</select>");
        out.println("		<br>");
        
        out.println("		<input type='submit' name='save' value='Update'>");
        out.println("	</form>");
	}
	
	
	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		final Long id = request.getParameter("id") != null ? new Long(request.getParameter("id").toString()) : 0L;
		final String description = 
				request.getParameter("description") != null 
				? request.getParameter("description").toString() : StringUtils.EMPTY;
		final Long stateId = 
				request.getParameter("stateId") != null 
				? new Long(request.getParameter("stateId").toString()) : 0L;
		
		CityServlet.LOGGER.info("Saving city: {} - {} - {}", id, description, stateId);
		
		City city = null;
		if (request.getParameter("update") == null) {
			city = cityService.save(id, description, stateId);
		}
		else { 
			city = cityService.update(id, description, stateId);
		}
				
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head><title>Cities</title></head>");
        out.println("<body>");
        
        out.println("	<h3>Added:</h3>");
        
        out.println("	id: " + city.getId() + "<br>");
        out.println("	Description: " + city.getDescription() + "<br>");
        out.println("	State: " + city.getState().getDescription() + "<br>");
        
        out.println("	<br>");
        out.println("	<a href='/servlet-app/index.html'>Return to Index</a>");
        
        out.println("</body>");
        out.println("</html>");
    }

}