package com.softtek.academy.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
/**
 * This class defines a 'MVC Controller' that delegates to the view layer. 
 * @author David.Hernandez
 */
@Controller
public class ContactViewController {
	
	final String message = "Welcome to Agenda-REST!";
 
	/**
	 * End-point that redirects to 'welcome.jsp' page.
	 * 
	 * @param (String) name - The name to say 'Hello!'
	 * @return (ModelAndView) - Model and view to redirect.
	 */
	@RequestMapping("/welcome")
	public ModelAndView welcome(
			@RequestParam(value = "name", required = false, defaultValue = "World!") final String name) {
		
		System.out.println("Welcome page of 'Agenda-REST application'");
 
		ModelAndView mav = new ModelAndView("welcome");
		mav.addObject("message", message);
		mav.addObject("name", name);
		return mav;
	}
}
