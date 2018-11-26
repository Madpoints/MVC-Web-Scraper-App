package com.madpoints.webscraper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.madpoints.webscraper.entity.Login;
import com.madpoints.webscraper.entity.User;

@Controller
public class HomeController {
	
	@GetMapping("/login")
	public String showLogin(Model theModel) {
		
		Login loginInfo = new Login();
		
		theModel.addAttribute("login", loginInfo);
		
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegistration(Model theModel) {
		
		User newUser = new User();
		
		theModel.addAttribute("user", newUser);
		
		return "register";
	}

}
