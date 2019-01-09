package com.madpoints.webscraper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madpoints.webscraper.dao.UserStockDAO;

@Service
public class UserStockServiceImpl implements UserStockService {
	
	@Autowired
	UserStockDAO userStockDAO;

}
