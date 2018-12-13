package com.madpoints.webscraper.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.madpoints.webscraper.entity.Stock;

public class StockDAOImpl implements StockDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Stock> getStocks() {
		
		return null;
	}

}
