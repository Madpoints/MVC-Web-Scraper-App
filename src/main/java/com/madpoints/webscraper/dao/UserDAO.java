package com.madpoints.webscraper.dao;

import com.madpoints.webscraper.entity.User;

public interface UserDAO {

	public User getUser(int userId);
	
	public void registerUser(User theUser);
	
	public void deleteUser(int userId);
	
}
