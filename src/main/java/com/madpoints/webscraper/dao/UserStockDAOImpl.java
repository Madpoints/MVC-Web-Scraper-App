package com.madpoints.webscraper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madpoints.webscraper.entity.Stock;
import com.madpoints.webscraper.entity.UserStock;

@Repository
public class UserStockDAOImpl implements UserStockDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public UserStock getUserStock(int userId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return null;
	}

	@Override
	public void saveUserStock(UserStock userStock) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(userStock);
	}

}
