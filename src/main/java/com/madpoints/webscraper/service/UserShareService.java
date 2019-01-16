package com.madpoints.webscraper.service;

import com.madpoints.webscraper.entity.UserShare;

public interface UserShareService {
	
	public UserShare getUserShare(int id);
	
	public void saveUserShare(UserShare userShare);
	
}
