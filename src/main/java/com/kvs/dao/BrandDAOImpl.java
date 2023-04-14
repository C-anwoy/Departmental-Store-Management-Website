package com.kvs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvs.entity.Brand;
import com.kvs.entity.Category;

@Repository
public class BrandDAOImpl implements BrandDAO{
	
	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Brand> getBrands() {
		
				//get the current hibernate session
				Session currentSession= sessionFactory.getCurrentSession();
				
				//create a query
				Query<Brand> theQuery=currentSession.createQuery("from Brand order by brandName", Brand.class);
				
				//execute query and get result list
				List<Brand> brands = theQuery.getResultList();
				
				//return the results
				return brands;
	}

	@Override
	public void saveBrand(Brand theBrand) {
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
						
				// save/update the category
				currentSession.saveOrUpdate(theBrand);
	}

	@Override
	public Brand getBrand(int theId) {
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
								
				//retrieve from database using primary key
				Brand theBrand=currentSession.get(Brand.class, theId);
										
				//return the results
				return theBrand;
	}

	@Override
	public void deleteBrand(int theId) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
						
		//delete from database using primary key
		Query theQuery=currentSession.createQuery("delete from Brand where id=:brandId");
		
		theQuery.setParameter("brandId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public Brand getBrandbyName(String brand) {
		
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// now retrieve/read from database using email id
				Query<Brand> theQuery = currentSession.createQuery("from Brand where brandName=:name", Brand.class);
				theQuery.setParameter("name", brand);
				Brand theBrand = theQuery.getSingleResult();

				return theBrand;
	}

}
