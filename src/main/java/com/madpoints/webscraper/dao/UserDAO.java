package com.madpoints.webscraper.dao;

import java.util.List;

import com.madpoints.webscraper.entity.User;

public interface UserDAO {
	
	public List<User> getUsers();

	public User getUser(int userId);
	
	public User getUser(String userName);
	
	public boolean registerUser(User newUser);
	
	public void deleteUser(int userId);
	
}
