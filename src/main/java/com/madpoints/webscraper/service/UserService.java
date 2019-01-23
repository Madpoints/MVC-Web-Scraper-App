package com.madpoints.webscraper.service;

import java.util.List;

import com.madpoints.webscraper.entity.User;

public interface UserService {
	
	public List<User> getUsers();

	public User getUser(int userId);
	
	@SuppressWarnings("rawtypes")
	public List getUser(String userName);
	
	public void saveOrUpdateUser(User user);
	
	public void deleteUser(int userId);
	
}
