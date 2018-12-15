package com.madpoints.webscraper.dao;

import java.util.List;

import com.madpoints.webscraper.entity.Stock;

public interface StockDAO {
	
	public List<Stock> getStocks();
	
	public void saveStock(Stock stock);
	
	

}
