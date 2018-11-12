package com.madpoints.webscraper.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madpoints.webscraper.entity.User;

@Repository
public class UserService {
	
	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	public void registerUser(User newUser) {
		
		// current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// register new user
		currentSession.saveOrUpdate(newUser);
	}
}
