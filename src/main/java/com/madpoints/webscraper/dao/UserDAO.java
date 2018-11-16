package com.madpoints.webscraper.dao;

import java.util.List;

import com.madpoints.webscraper.entity.User;

public interface UserDAO {
	
	public List<User> getUsers();

	public User getUser(int userId);
	
	public void registerUser(User theUser);
	
	public void deleteUser(int userId);
	
}
