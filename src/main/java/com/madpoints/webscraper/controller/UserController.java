package com.madpoints.webscraper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String loginUser(@ModelAttribute("login") Login loginInfo, RedirectAttributes redirectAtt) {
		
		int userId = loginUser(loginInfo);

		if (userId < 0) {
			
			return "redirect:/login";
		}
		
		redirectAtt.addAttribute("userId", userId);
		
		return "redirect:/home/{userId}";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User newUser, RedirectAttributes redirectAtt) {
		
		if (!userService.registerUser(newUser)) {
		
			return "redirect:/register";
		}
		
		redirectAtt.addAttribute("userId", newUser.getId());
		
		return "redirect:/home/{userId}";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int userId) {
		
		userService.deleteUser(userId);
		
		return "redirect:/login";
	}
	
	private int loginUser(Login login) {
		
		User loggedInUser = userService.getUser(login.getUserName());
		
		if (loggedInUser ==  null || 
			!loggedInUser.getPassword().equals(login.getPassword())) {
			
			return -1;
		}
		
		return loggedInUser.getId();	
	}
	

}
