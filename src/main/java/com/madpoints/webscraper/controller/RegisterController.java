package com.madpoints.webscraper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.madpoints.webscraper.entity.User;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@GetMapping("/new")
	public String showRegistration(Model theModel) {
		
		User user = new User();
		
		theModel.addAttribute("user", user);
		
		return "register";
	}
	
	// post mapping needed for register and user needs to be added to the model

}
