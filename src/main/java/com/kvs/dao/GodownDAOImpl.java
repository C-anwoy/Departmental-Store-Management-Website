package com.kvs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvs.entity.Godown;
import com.kvs.entity.Vendor;

@Repository
public class GodownDAOImpl implements GodownDAO {
	
	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Godown> getGodowns() {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
				
				//create a query
				Query<Godown> theQuery=currentSession.createQuery("from Godown", 
																	Godown.class);
						
				//execute query and get result list
				List<Godown> godowns = theQuery.getResultList();
						
				//return the results
				return godowns;
	}

	@Override
	public void saveGodown(Godown theGodown) {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
				
				// save/update the vendor
				currentSession.saveOrUpdate(theGodown);

	}

	@Override
	public Godown getGodown(int theId) {
	
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
						
				//retrieve from database using primary key
				Godown theGodown=currentSession.get(Godown.class, theId);
								
				//return the results
				return theGodown;
	}

	@Override
	public void deleteGodown(int theId) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
						
		//delete from database using primary key
		Query theQuery=currentSession.createQuery("delete from Godown where id=:godownId");
		
		theQuery.setParameter("godownId", theId);
		
		theQuery.executeUpdate();

	}

}
