package com.madpoints.webscraper.service;

import com.madpoints.webscraper.entity.Share;

public interface ShareService {
	
	public Share getShare(int id);
	
	public Share getShare(Share share);
	
	public void saveShare(Share share);
	
}
