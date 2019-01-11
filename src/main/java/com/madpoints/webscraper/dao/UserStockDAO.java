package com.madpoints.webscraper.dao;

import java.util.List;

import com.madpoints.webscraper.entity.Stock;
import com.madpoints.webscraper.entity.UserStock;

public interface UserStockDAO {

	public List<Stock> getUserStocks(int userId);
	
	public void saveUserStock(UserStock userStock);
	
}
