package com.kvs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvs.entity.OfflineCounter;
import com.kvs.entity.OnlineCounter;

@Repository
public class CounterDAOImpl implements CounterDAO {

		//inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
		
	@Override
	public void saveOnlineCounter(OnlineCounter theCounter) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
				
		// save/update the category
		currentSession.saveOrUpdate(theCounter);
		
	}

	@Override
	public List<OnlineCounter> getOnlineCounters() {
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
						
		Query<OnlineCounter> theQuery = currentSession.createQuery("from OnlineCounter", OnlineCounter.class);
		
		List<OnlineCounter> counters = theQuery.getResultList();
		return counters;
	}

	@Override
	public OnlineCounter getOnlineCounter(int counterId) {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
						
				// get by primary key
				OnlineCounter theCounter=currentSession.get(OnlineCounter.class, counterId);
				
				return theCounter;
	}

	@Override
	public void saveOfflineCounter(OfflineCounter theCounter) {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
						
				// save/update the category
				currentSession.saveOrUpdate(theCounter);
		
	}

	@Override
	public List<OfflineCounter> getOfflineCounters() {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
								
				Query<OfflineCounter> theQuery = currentSession.createQuery("from OfflineCounter", OfflineCounter.class);
				
				List<OfflineCounter> counters = theQuery.getResultList();
				return counters;
	}

	@Override
	public OfflineCounter getOfflineCounter(int counterId) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
				
		// get by primary key
		OfflineCounter theCounter=currentSession.get(OfflineCounter.class, counterId);
		
		return theCounter;
	}

}
