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
	public Share getUserShare(int id) {

		return userStockDAO.getUserShare(id);
	}

	@Override
	@Transactional
	public void saveUserShare(Share userShare) {
		
		userStockDAO.saveUserShare(userShare);
	}

}
