package com.madpoints.webscraper.service;

import com.madpoints.webscraper.entity.UserStock;

public interface UserStockService {
	
	public UserStock getUserStock(int id);
	
	public void saveUserStock(UserStock userStock);
	
}
