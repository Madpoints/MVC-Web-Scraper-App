package com.madpoints.webscraper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.madpoints.webscraper.entity.User;
import com.madpoints.webscraper.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String submit(Model theModel) {
		
		List<User> theUsers = userService.getUsers();
		
		theModel.addAttribute("user", theUsers);
		
		return "home";
	}
}

