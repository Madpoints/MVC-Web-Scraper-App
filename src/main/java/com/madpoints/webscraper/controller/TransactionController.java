package com.madpoints.webscraper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.madpoints.webscraper.entity.Share;
import com.madpoints.webscraper.entity.Stock;
import com.madpoints.webscraper.entity.User;
import com.madpoints.webscraper.service.ShareService;
import com.madpoints.webscraper.service.StockService;
import com.madpoints.webscraper.service.UserService;

@Controller
public class TransactionController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private ShareService shareService;
	
	@PostMapping("/buy")
	public String buyStock() {
		
		return "home";
	}
	
	@PostMapping("/sell")
	public String sellStock() {
		
		return "home";
	}
	
	public void stockTransaction(User user, Stock stock, Share share) {
		
		user.addStock(stock);
		user.addShare(share);
		
		userService.saveOrUpdateUser(user);
	}
	
	public void stockTrade(User userA, User userB, Stock stock, Share share) {
		
		userA.getStocks().remove(stock);
		userB.getStocks().add(stock);
		
		userService.saveOrUpdateUser(userA);
		userService.saveOrUpdateUser(userB);
	}
	

}
