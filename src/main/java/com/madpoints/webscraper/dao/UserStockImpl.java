package com.madpoints.webscraper.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madpoints.webscraper.entity.Stock;

@Repository
public class UserStockImpl implements UserStockDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public List<Stock> getUserStocks(int userId) {
		
		return null;
	}

}
