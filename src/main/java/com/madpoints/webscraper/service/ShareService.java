package com.madpoints.webscraper.service;

import java.util.List;

import com.madpoints.webscraper.entity.Share;

public interface ShareService {
	
	public Share getShare(int id);
	
	@SuppressWarnings("rawtypes")
	public List getShare(Share share);
	
	public void saveShare(Share share);
	
	public void deleteShare(int id);
	
}
