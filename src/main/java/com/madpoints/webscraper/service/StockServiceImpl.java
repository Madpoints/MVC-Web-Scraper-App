package com.madpoints.webscraper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.madpoints.webscraper.dao.StockDAO;
import com.madpoints.webscraper.entity.Stock;

public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockDAO stockDAO;

	@Override
	public List<Stock> getStocks() {
		
		return stockDAO.getStocks();
	}

}
