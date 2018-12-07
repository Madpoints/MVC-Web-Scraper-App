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
	
	@SuppressWarnings("rawtypes")
	@Override
	public int loginUser(Login login) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from User where userName=:userName");
		
		theQuery.setParameter("userName", login.getUserName());
		
		List results = theQuery.getResultList();
		
		if (results.isEmpty()) {
			
			return -1;
		}
		
		// get first result and cast it to a User
		User loggedInUser = (User) theQuery.getResultList().get(0);
		
		if (!loggedInUser.getPassword().equals(login.getPassword())) {
			
			return -1;
		}
		
		return loggedInUser.getId();
		
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
