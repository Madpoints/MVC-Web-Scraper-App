package com.madpoints.webscraper.dao;

import com.madpoints.webscraper.entity.UserShare;

public interface UserShareDAO {

	public UserShare getUserShare(int id);
	
	public void saveUserShare(UserShare userShareS);
	
}
