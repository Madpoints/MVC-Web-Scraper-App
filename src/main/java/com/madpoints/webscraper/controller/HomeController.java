package com.madpoints.webscraper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.madpoints.webscraper.entity.Login;

@Controller
public class HomeController {
	
	@GetMapping("/login")
	public String showLogin(Model theModel) {
		
		theModel.addAttribute("login", new Login());
		
		return "login";
	}

}
