package com.madpoints.webscraper.dao;

import java.util.List;

import com.madpoints.webscraper.entity.Stock;

public interface StockDAO {
	
	public List<Stock> getStocks();
	
	public Stock getStock(int stockId);
	
	public void saveStock(List<Stock> stocks);
	
	public void buyStock(int stockId);
	
	public void sellStock(int stockId);

}
