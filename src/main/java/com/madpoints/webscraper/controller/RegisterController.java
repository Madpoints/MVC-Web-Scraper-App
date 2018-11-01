package com.madpoints.webscraper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	
	@GetMapping("/register")
	public String showRegistration() {
		
		return "register";
	}

	@PostMapping("/register")
	public String register() {
		
		return "submit";
	}
	
}
