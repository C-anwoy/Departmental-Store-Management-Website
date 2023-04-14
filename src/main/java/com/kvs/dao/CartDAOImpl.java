package com.kvs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvs.entity.Category;
import com.kvs.entity.Product;
import com.kvs.entity.ProductsInCart;
import com.kvs.entity.ProductsInCartId;
import com.kvs.entity.User;

@Repository
public class CartDAOImpl implements CartDAO {
	
	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCart(ProductsInCart productInCart) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
						
		// save/update the category
		currentSession.saveOrUpdate(productInCart);
	}

	@Override
	public ProductsInCart findProductInCart(User customer, Product product) {
		
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				//key
				ProductsInCartId theKey= new ProductsInCartId(customer, product);

				// now retrieve/read from database using username
				//Query<ProductsInCart> theQuery = currentSession.createQuery("from ProductsInCart where primaryKey=:key", ProductsInCart.class);
				//theQuery.setParameter("key", theKey);
				
				ProductsInCart theproductsInCart = null;
				try {
					theproductsInCart = currentSession.get(ProductsInCart.class, theKey);
				} catch (Exception e) {
					theproductsInCart = null;
				}

				return theproductsInCart;
	}

	@Override
	public List<ProductsInCart> getProductsInCart(User customer) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<ProductsInCart> theQuery = currentSession.createQuery("from ProductsInCart where primaryKey.customer=:c", 
																		ProductsInCart.class);
		theQuery.setParameter("c", customer);
		
		List<ProductsInCart> cartProducts = theQuery.getResultList();

		return cartProducts;
	}

	@Override
	public void removeProduct(ProductsInCartId primarykey) {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
								
				//delete from database using primary key
				Query theQuery=currentSession.createQuery("delete from ProductsInCart where primaryKey=:key");
				
				theQuery.setParameter("key", primarykey);
				
				theQuery.executeUpdate();
		
	}

	@Override
	public void deleteCartProducts(User customer) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
						
		//delete from database using primary key
		Query theQuery=currentSession.createQuery("delete from ProductsInCart where primaryKey.customer=:c");
		
		theQuery.setParameter("c", customer);
		
		theQuery.executeUpdate();
		
	}

}
