package com.madpoints.webscraper.dao;

import com.madpoints.webscraper.entity.UserStock;

public interface UserStockDAO {

	public UserStock getUserStock(int id);
	
	public void saveUserStock(UserStock userStock);
	
}
