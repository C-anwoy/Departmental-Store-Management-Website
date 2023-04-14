package com.kvs.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvs.entity.OfflineCounter;
import com.kvs.entity.OnlineCounter;
import com.kvs.entity.Role;
import com.kvs.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(Integer theUserName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}
	
	
	@Override
	public User findByEmail(String email) {
		
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// now retrieve/read from database using email id
				Query<User> theQuery = currentSession.createQuery("from User where email=:eid", User.class);
				theQuery.setParameter("eid", email);
				User theUser = null;
				try {
					theUser = theQuery.getSingleResult();
				} catch (Exception e) {
					theUser = null;
				}

				return theUser;
	}

	@Override
	public void save(User theUser) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the user
		currentSession.saveOrUpdate(theUser);
	}


	
	@Override
	public List getUsersbyRole(String roleName) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using email id
		//System.out.println("in DAO");
		Query theQuery = currentSession.createQuery("select U.userName from User U inner join U.roles R with R.name=:r");
		theQuery.setParameter("r", roleName);
		//System.out.println(role);
		List theUserIds = theQuery.getResultList();
		//System.out.println(theUsers);
		return theUserIds;
	}


	@Override
	public void updateStaff(User theStaff) {
		
				// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// create the user
				currentSession.saveOrUpdate(theStaff);
		
	}


	@Override
	public OnlineCounter getOnlineCounter(int staff_id) {
		
		
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using email id
		//System.out.println("in DAO");
		Query theQuery = currentSession.createQuery("select onlineCounter from User where userName=:id");
		theQuery.setParameter("id", staff_id);
		
		OnlineCounter theCounter = (OnlineCounter) theQuery.getSingleResult();
		//System.out.println(theUsers);
		return theCounter;
	}


	@Override
	public OfflineCounter getOfflineCounter(int staff_id) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using email id
		//System.out.println("in DAO");
		Query theQuery = currentSession.createQuery("select offlineCounter from User where userName=:id");
		theQuery.setParameter("id", staff_id);
		
		OfflineCounter theCounter = (OfflineCounter) theQuery.getSingleResult();
		//System.out.println(theUsers);
		return theCounter;
	}

	

}
