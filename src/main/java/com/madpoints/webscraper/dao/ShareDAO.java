package com.madpoints.webscraper.dao;

import com.madpoints.webscraper.entity.Share;

public interface ShareDAO {

	public Share getUserShare(int id);
	
	public void saveUserShare(Share userShareS);
	
}
