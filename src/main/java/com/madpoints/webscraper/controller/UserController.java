package com.madpoints.webscraper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.madpoints.webscraper.entity.Login;
import com.madpoints.webscraper.entity.User;
import com.madpoints.webscraper.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute("login") Login loginInfo, Model theModel) {
		
		userService.loginUser(loginInfo);
		
		return "redirect:/home";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User newUser, RedirectAttributes redirectAtt) {
		
		userService.registerUser(newUser);
		
		redirectAtt.addAttribute("userId", newUser.getId());
	
		return "redirect:/home/{userId}";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int userId) {
		
		return "redirect:/login";
	}
	

}
