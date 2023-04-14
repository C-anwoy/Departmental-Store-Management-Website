package com.kvs.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvs.entity.Category;
import com.kvs.entity.User;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getCategories() {

		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//create a query
		Query<Category> theQuery=currentSession.createQuery("from Category order by id", Category.class);
		
		//execute query and get result list
		List<Category> categories = theQuery.getResultList();
		
		//return the results
		return categories;
	}

	@Override
	public Category getCategory(int theId) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
						
		//retrieve from database using primary key
		Category theCategory=currentSession.get(Category.class, theId);
								
		//return the results
		return theCategory;
	}

	@Override
	public void saveCategory(Category theCategory) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
				
		// save/update the category
		currentSession.saveOrUpdate(theCategory);
		
	}

	@Override
	public void deleteCategory(int theId) {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
								
				//delete from database using primary key
				Query theQuery=currentSession.createQuery("delete from Category where id=:catId");
				
				theQuery.setParameter("catId", theId);
				
				theQuery.executeUpdate();
				
		
	}

	@Override
	public Category getCategorybyName(String categoryName) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using email id
		Query<Category> theQuery = currentSession.createQuery("from Category where catName=:name", Category.class);
		theQuery.setParameter("name", categoryName);
		Category theCategory = theQuery.getSingleResult();

		return theCategory;
	}
	
	

}
