package com.kvs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvs.entity.Category;
import com.kvs.entity.Product;
import com.kvs.entity.Vendor;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public List<Product> findProductbyCat(int categoryId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get the category
		Category theCategory=categoryDAO.getCategory(categoryId);

		// now retrieve/read from database using email id
		Query<Product> theQuery = currentSession.createQuery("from Product where category=:cat", Product.class);
		theQuery.setParameter("cat", theCategory);
		
		//execute query and get result list
		List<Product> products = theQuery.getResultList();

		return products;
	}
	
	@Override
	public List<Product> getProducts() {
		
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// now retrieve/read from database using email id
				Query<Product> theQuery = currentSession.createQuery("from Product order by id", Product.class);
				
				//execute query and get result list
				List<Product> products = theQuery.getResultList();

				return products;
	}

	@Override
	public void saveProduct(Product theProduct) {
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
						
		// save/update the product
		currentSession.saveOrUpdate(theProduct);
		
	}

	@Override
	public Product getProduct(int theId) {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
						
				//retrieve from database using primary key
				Product theProduct=currentSession.get(Product.class, theId);
								
				//return the results
				return theProduct;
	}

	@Override
	public List<Product> findProductbyCatAndQty(int categoryId) {
		
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				//get the category
				Category theCategory=categoryDAO.getCategory(categoryId);

				// now retrieve/read from database using email id
				Query<Product> theQuery = currentSession.createQuery("from Product where category=:cat and stock > 0", Product.class);
				theQuery.setParameter("cat", theCategory);
				
				//execute query and get result list
				List<Product> products = theQuery.getResultList();

				return products;
	}

	

}
