package com.madpoints.webscraper.dao;

import java.util.List;

import com.madpoints.webscraper.entity.Stock;

public interface UserStockDAO {

	public List<Stock> getUserStocks(int userId);
	
}
