package com.madpoints.webscraper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madpoints.webscraper.dao.StockDAO;
import com.madpoints.webscraper.entity.Stock;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockDAO stockDAO;

	@Override
	public List<Stock> getStocks() {
		
		return stockDAO.getStocks();
	}

	@Override
	public Stock getStock(int stockId) {
		
		return stockDAO.getStock(stockId);
	}

	@Override
	public void saveStock(List<Stock> stocks) {
		
		stockDAO.saveStock(stocks);
	}

}
