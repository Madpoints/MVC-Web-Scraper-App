package com.madpoints.webscraper.service;

import com.madpoints.webscraper.entity.User;

public interface UserService {

	public User getUser(int userId);
	
	public void registerUser(User theUser);
	
	public void deleteUser(int userId);
	
}
