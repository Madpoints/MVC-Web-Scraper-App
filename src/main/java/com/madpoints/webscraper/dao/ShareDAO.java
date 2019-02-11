package com.madpoints.webscraper.dao;

import com.madpoints.webscraper.entity.Share;

public interface ShareDAO {

	public Share getShare(int id);
	
	public Share getShare(Share share);
	
	public void saveShare(Share share);
	
}
