package com.madpoints.webscraper.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madpoints.webscraper.entity.UserShare;

@Repository
public class UserShareDAOImpl implements UserShareDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public UserShare getUserShare(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return null;
	}

	@Override
	public void saveUserShare(UserShare userShare) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(userShare);
	}

}
