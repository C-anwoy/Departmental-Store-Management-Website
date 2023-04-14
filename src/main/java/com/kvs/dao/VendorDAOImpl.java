package com.kvs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvs.entity.Vendor;

@Repository
public class VendorDAOImpl implements VendorDAO {
	
	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Vendor> getVendors() {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//create a query
		Query<Vendor> theQuery=currentSession.createQuery("from Vendor order by id", 
															Vendor.class);
				
		//execute query and get result list
		List<Vendor> vendors = theQuery.getResultList();
				
		//return the results
		return vendors;
	}

	@Override
	public void saveVendor(Vendor theVendor) {
	
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		// save/update the vendor
		currentSession.saveOrUpdate(theVendor);

	}

	@Override
	public Vendor getVendor(int theId) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
				
		//retrieve from database using primary key
		Vendor theVendor=currentSession.get(Vendor.class, theId);
						
		//return the results
		return theVendor;
	}

	@Override
	public void deleteVendor(int theId) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
						
		//delete from database using primary key
		Query theQuery=currentSession.createQuery("delete from Vendor where id=:vendorId");
		
		theQuery.setParameter("vendorId", theId);
		
		theQuery.executeUpdate();
		
	}

}
