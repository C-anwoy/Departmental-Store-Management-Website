package com.kvs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvs.entity.Supply;
import com.kvs.entity.Vendor;

@Repository
public class SupplyDAOImpl implements SupplyDAO {
	
			//inject the session factory
			@Autowired
			private SessionFactory sessionFactory;

	@Override
	public void saveSupply(Supply theSupply) {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
				
				// save order
				currentSession.saveOrUpdate(theSupply);

	}

	@Override
	public List<Supply> getSupplybyVendor(Vendor theVendor) {
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Supply> theQuery = currentSession.createQuery("from Supply where primaryKey.vendor =: v", Supply.class);
		theQuery.setParameter("v", theVendor);
		
		List<Supply> theSupplies = theQuery.getResultList();
		
		return theSupplies;
	}

}
