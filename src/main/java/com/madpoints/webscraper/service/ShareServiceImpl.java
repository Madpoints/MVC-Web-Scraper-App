package com.madpoints.webscraper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madpoints.webscraper.dao.ShareDAO;
import com.madpoints.webscraper.entity.Share;

@Service
public class ShareServiceImpl implements ShareService {
	
	@Autowired
	ShareDAO userStockDAO;

	@Override
	@Transactional
	public Share getShare(int id) {

		return userStockDAO.getShare(id);
	}
	
	@Override
	@Transactional
	public Share getShare(Share share) {
		
		return userStockDAO.getShare(share);
	}

	@Override
	@Transactional
	public void saveShare(Share userShare) {
		
		userStockDAO.saveShare(userShare);
	}

}
