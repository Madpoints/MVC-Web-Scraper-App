package com.madpoints.webscraper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		
		return currentSession.get(Share.class, id);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List getShare(Share share) {
		
		int userId = share.getUserId();
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Share where userId=:userId");
		
		theQuery.setParameter("userId", userId);
		
		return theQuery.getResultList();
	}

	@Override
	public void saveShare(Share share) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(share);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteShare(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = 
				currentSession.createQuery("delete from Share where id=:id");
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();	
	}

}
