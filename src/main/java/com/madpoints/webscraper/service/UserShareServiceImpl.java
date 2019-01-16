package com.madpoints.webscraper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madpoints.webscraper.dao.UserShareDAO;
import com.madpoints.webscraper.entity.UserShare;

@Service
public class UserShareServiceImpl implements UserShareService {
	
	@Autowired
	UserShareDAO userStockDAO;

	@Override
	@Transactional
	public UserShare getUserShare(int id) {

		return userStockDAO.getUserShare(id);
	}

	@Override
	@Transactional
	public void saveUserShare(UserShare userShare) {
		
		userStockDAO.saveUserShare(userShare);
	}

}
