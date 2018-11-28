package com.madpoints.webscraper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madpoints.webscraper.entity.Login;
import com.madpoints.webscraper.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> theQuery = 
				currentSession.createQuery("from User order by userName",
											User.class);
		
		List<User> users = theQuery.getResultList();
		
		return users;
	}

	@Override
	public User getUser(int userId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		User theUser = currentSession.get(User.class, userId);
		
		return theUser;
	}
	
	@Override
	public void loginUser(Login login) {
		
		// use login class to search db for user
		
		// if user not found redirect to registration page
		
		// if user found compare users password with login password
		
		// if password does not match redirect to login page
		
		// return user
		
	}

	@Override
	public void registerUser(User user) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(user);
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteUser(int userId) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from User where id=:userId");
		theQuery.setParameter("userId", userId);
		
		theQuery.executeUpdate();	

	}

}
