package com.madpoints.webscraper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.madpoints.webscraper.entity.Login;
import com.madpoints.webscraper.entity.Share;
import com.madpoints.webscraper.entity.Stock;
import com.madpoints.webscraper.entity.User;
import com.madpoints.webscraper.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public String login(@ModelAttribute("login") Login login, RedirectAttributes redirectAtt) {
		
		List results = userService.getUser(login.getUserName());
		
		if (results.isEmpty()) {
			
			return "redirect:/login";
		}
		
		User user = (User) results.get(0);
		
		if (!user.getPassword().equals(login.getPassword())) {
			
			return "redirect:/login";
		}
		
		redirectAtt.addAttribute("userId", user.getId());
		
		return "redirect:/home/{userId}";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User newUser, RedirectAttributes redirectAtt) {
		
		if (!userService.getUser(newUser.getUserName()).isEmpty()) {
			
			return "redirect:/register";
		}
		
		userService.saveOrUpdateUser(newUser);
		
		redirectAtt.addAttribute("userId", newUser.getId());
		
		return "redirect:/home/{userId}";
	}
	
	@GetMapping("/home/{userId}")
	public String displayHome(@PathVariable("userId") int userId,
								Model theModel) {
		
		User theUser = userService.getUser(userId);
		
		theModel.addAttribute("theUser", theUser);
		theModel.addAttribute("stocks", theUser.getStocks());
		
		return "home";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int userId) {
		
		userService.deleteUser(userId);
		
		return "redirect:/login";
	}
	
	private static void stockTransaction(User user, Stock stock, Share share) {
		
		user.addStock(stock);
		
		
	}

}
