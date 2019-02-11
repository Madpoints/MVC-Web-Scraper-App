package com.madpoints.webscraper.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madpoints.webscraper.entity.Share;

@Repository
public class ShareDAOImpl implements ShareDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public Share getShare(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return null;
	}
	
	@Override
	public Share getShare(Share share) {
		
		int userId = share.getUserId();
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return null;
	}

	@Override
	public void saveShare(Share share) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(share);
	}

}
