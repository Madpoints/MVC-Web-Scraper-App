package com.madpoints.webscraper.service;

import java.util.List;

import com.madpoints.webscraper.entity.Login;
import com.madpoints.webscraper.entity.User;

public interface UserService {
	
	public List<User> getUsers();

	public User getUser(int userId);
	
	public int loginUser(Login login);
	
	public void registerUser(User theUser);
	
	public void deleteUser(int userId);
	
}
