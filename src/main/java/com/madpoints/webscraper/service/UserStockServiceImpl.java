package com.madpoints.webscraper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madpoints.webscraper.dao.UserStockDAO;
import com.madpoints.webscraper.entity.Stock;
import com.madpoints.webscraper.entity.UserStock;

@Service
public class UserStockServiceImpl implements UserStockService {
	
	@Autowired
	UserStockDAO userStockDAO;

	@Override
	@Transactional
	public List<Stock> getUserStocks(int userId) {

		return userStockDAO.getUserStocks(userId);
	}

	@Override
	@Transactional
	public void saveUserStock(UserStock userStock) {
		
		userStockDAO.saveUserStock(userStock);
	}

}
