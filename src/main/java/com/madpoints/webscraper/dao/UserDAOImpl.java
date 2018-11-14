package com.madpoints.webscraper.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madpoints.webscraper.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUser(int userId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		User theUser = currentSession.get(User.class, userId);
		
		return theUser;
	}

	@Override
	public void registerUser(User theUser) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theUser);
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteUser(int userId) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:userId");
		theQuery.setParameter("userId", userId);
		
		theQuery.executeUpdate();	

	}

}
