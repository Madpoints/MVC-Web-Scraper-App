package com.madpoints.webscraper.service;

import java.util.List;

import com.madpoints.webscraper.entity.User;

public interface UserService {
	
	public List<User> getUsers();

	public User getUser(int userId);
	
	public User getUser(String userName);
	
	public boolean registerUser(User theUser);
	
	public void deleteUser(int userId);
	
}
