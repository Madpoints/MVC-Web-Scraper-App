package com.madpoints.webscraper.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.madpoints.webscraper.entity.User;

@Repository
public class UserService {
	
	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	public void registerUser(User newUser) {
		
	}
	
	@Transactional
	public User getUser() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		User theUser = currentSession.get(User.class, 1);
		
		return theUser;
	}
}
