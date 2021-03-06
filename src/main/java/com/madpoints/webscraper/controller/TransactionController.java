package com.madpoints.webscraper.controller;

import java.util.List;

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
	public String buyStock(Share share) {
		
		stockTransaction(share);
		
		return "home";
	}
	
	@PostMapping("/sell")
	public String sellStock(Share share) {
		
		stockTransaction(share);
		
		return "home";
	}
	
	@SuppressWarnings("rawtypes")
	public void stockTransaction(Share share) {
		
		List resultList = shareService.getShare(share);
		
		User theUser = userService.getUser(share.getUserId());
		
		List<Share> userShares = theUser.getShares();
		List<Stock> userStocks = theUser.getStocks();
		
		Stock theStock = stockService.getStock(share.getStockId());	
		
		if (resultList.isEmpty()) {
			
			shareService.saveShare(share);
			
			theUser.addShare(share);
			theUser.addStock(theStock);
			
		} else {
			
			Share theShare = (Share) resultList.get(0);
			
			int sharesOwned = theShare.getShares();
			int tempShares = share.getShares();
			int newShares = sharesOwned + tempShares;
			
			if (newShares <= 0) {
				
				shareService.deleteShare(theShare.getId());
				
				userStocks.remove(theStock);
				userShares.remove(theShare);
				
				theUser.setStocks(userStocks);
				theUser.setShares(userShares);
				
				userService.saveOrUpdateUser(theUser);
				
			} else {
				
				theUser.getShares().remove(theShare);
				
				theShare.setShares(newShares);
				
				shareService.saveShare(theShare);
				
			}
			
		}
		
		
	}
	
	public void stockTrade(User userA, User userB, Stock stock, Share share) {
		
		userA.getStocks().remove(stock);
		userB.getStocks().add(stock);
		
		userService.saveOrUpdateUser(userA);
		userService.saveOrUpdateUser(userB);
	}
	

}
