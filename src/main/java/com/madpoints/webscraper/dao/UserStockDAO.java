package com.madpoints.webscraper.dao;

import com.madpoints.webscraper.entity.UserStock;

public interface UserStockDAO {

	public UserStock getUserStock(int userId);
	
	public void saveUserStock(UserStock userStock);
	
}
