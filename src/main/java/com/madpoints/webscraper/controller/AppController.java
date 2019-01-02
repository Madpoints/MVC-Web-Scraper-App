package com.madpoints.webscraper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.madpoints.webscraper.entity.Login;
import com.madpoints.webscraper.entity.User;
import com.madpoints.webscraper.service.StockService;
import com.madpoints.webscraper.service.UserService;

@Controller
public class AppController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StockService stockService;
	
	@GetMapping("/login")
	public String displayLogin(Model theModel) {
		
		Login loginInfo = new Login();
		
		theModel.addAttribute("login", loginInfo);
		
		return "login";
	}
	
	@GetMapping("/register")
	public String displayRegistration(Model theModel) {
		
		User newUser = new User();
		
		theModel.addAttribute("user", newUser);
		
		return "register";
	}
	
	@GetMapping("/home/{userId}")
	public String displayHome(@PathVariable("userId") int userId,
								Model theModel) {
		
		User theUser = userService.getUser(userId);
		
		theModel.addAttribute("theUser", theUser);
		
		return "home";
	}

}
