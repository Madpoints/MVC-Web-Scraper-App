package com.madpoints.webscraper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.madpoints.webscraper.entity.Login;
import com.madpoints.webscraper.entity.User;
import com.madpoints.webscraper.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String login(@ModelAttribute("login") Login login, Model theModel) {
		
		userService.loginUser(login);
		
		return "home";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user) {
		
		userService.registerUser(user);
	
		return "home";
	}

}
