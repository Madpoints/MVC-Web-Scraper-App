package com.madpoints.webscraper.service;

import java.util.List;

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
	public List<User> getUsers() {
		
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		
		return userDAO.getUser(userId);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public List getUser(String userName) {
		
		return userDAO.getUser(userName);
	}


	@Override
	@Transactional
	public void saveOrUpdateUser(User user) {
		
		 userDAO.saveOrUpdateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		
		userDAO.deleteUser(userId);
	}

}
