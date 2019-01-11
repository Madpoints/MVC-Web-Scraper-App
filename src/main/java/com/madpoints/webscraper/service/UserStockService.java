package com.madpoints.webscraper.service;

import java.util.List;

import com.madpoints.webscraper.entity.Stock;
import com.madpoints.webscraper.entity.UserStock;

public interface UserStockService {
	
	public List<Stock> getUserStocks(int userId);
	
	public void saveUserStock(UserStock userStock);
	
}
