package com.madpoints.webscraper.service;

import com.madpoints.webscraper.entity.Share;

public interface ShareService {
	
	public Share getUserShare(int id);
	
	public void saveUserShare(Share userShare);
	
}
