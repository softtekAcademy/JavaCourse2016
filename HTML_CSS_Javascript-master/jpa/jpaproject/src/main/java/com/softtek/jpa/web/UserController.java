package com.softtek.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softtek.jpa.domain.UserEntity;
import com.softtek.jpa.services.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users")
	public String listUsers(Model model){
		List<UserEntity> users = userService.findUsers();
		model.addAttribute("users",users);
		return "index";
	}
	
}
