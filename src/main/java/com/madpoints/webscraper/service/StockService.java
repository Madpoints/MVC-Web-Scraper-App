package com.madpoints.webscraper.service;

import java.util.List;

import com.madpoints.webscraper.entity.Stock;

public interface StockService {
	
	public List<Stock> getStocks();
	
	public Stock getStock(int stockId);
	
	public void saveStock(List<Stock> stocks);
	
}
