package com.madpoints.webscraper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madpoints.webscraper.dao.UserDAO;
import com.madpoints.webscraper.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public User getUser(int userId) {
		
		return userDAO.getUser(userId);
	}

	@Override
	@Transactional
	public void registerUser(User theUser) {
		
		userDAO.registerUser(theUser);
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		
		userDAO.deleteUser(userId);
	}
	
	
}
