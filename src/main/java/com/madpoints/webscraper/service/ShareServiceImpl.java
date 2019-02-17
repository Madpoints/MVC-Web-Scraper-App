package com.madpoints.webscraper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madpoints.webscraper.dao.ShareDAO;
import com.madpoints.webscraper.entity.Share;

@Service
public class ShareServiceImpl implements ShareService {
	
	@Autowired
	ShareDAO shareDAO;

	@Override
	@Transactional
	public Share getShare(int id) {

		return shareDAO.getShare(id);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public List getShare(Share share) {
		
		return shareDAO.getShare(share);
	}

	@Override
	@Transactional
	public void saveShare(Share userShare) {
		
		shareDAO.saveShare(userShare);
	}

	@Override
	public void deleteShare(int id) {
		
		shareDAO.deleteShare(id);
	}

}
