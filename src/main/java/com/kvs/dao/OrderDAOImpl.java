package com.kvs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvs.entity.Category;
import com.kvs.entity.OnlineCounter;
import com.kvs.entity.Order;
import com.kvs.entity.OrderedProducts;
import com.kvs.entity.Product;
import com.kvs.entity.ProductsInCart;
import com.kvs.entity.User;

@Repository
public class OrderDAOImpl implements OrderDAO{
	
		//inject the session factory
		@Autowired
		private SessionFactory sessionFactory;

	@Override
	public int saveOrder(Order theOrder) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
				
		// save order
		int id = ((Integer)currentSession.save(theOrder)).intValue();
		
		return id;
	}
	
	
	@Override
	public void updateOrder(Order theOrder) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
				
		// update order
		currentSession.saveOrUpdate(theOrder);
		
	}

	@Override
	public Order getOrder(int orderId) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
				
		//retrieve from database using primary key
		Order theOrder=currentSession.get(Order.class, orderId);
						
		//return the results
		return theOrder;
	}

	@Override
	public void saveOrderedProducts(OrderedProducts orderProduct) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		// save order
		currentSession.save(orderProduct);
		
	}

	@Override
	public List<Order> getOrders(User customer) {
		
				//get the current hibernate session
				Session currentSession= sessionFactory.getCurrentSession();
				
				//create a query
				Query<Order> theQuery=currentSession.createQuery("from Order where customer=:c", Order.class);
				theQuery.setParameter("c", customer);
				
				//execute query and get result list
				List<Order> theOrders = theQuery.getResultList();
				
				//return the results
				return theOrders;
	}

	@Override
	public Order getTheOrder(int orderId) {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
								
				//retrieve from database using primary key
				Order theOrder=currentSession.get(Order.class, orderId);
										
				//return the results
				return theOrder;
	}

	@Override
	public List<OrderedProducts> getProductsInOrder(Order theOrder) {
		
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				Query<OrderedProducts> theQuery = currentSession.createQuery("from OrderedProducts where primaryKey.order=:o", 
																				OrderedProducts.class);
				theQuery.setParameter("o", theOrder);
				
				List<OrderedProducts> orderProducts = theQuery.getResultList();

				return orderProducts;
	}

	@Override
	public List<Order> getOrdersByStatus(String status) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Order> theQuery = currentSession.createQuery("from Order where status=:s", 
																		Order.class);
		theQuery.setParameter("s", status);
		
		List<Order> theOrders = theQuery.getResultList();

		return theOrders;
	}


	@Override
	public List<Order> getOrdersByCounterAndStatus(OnlineCounter counter, String status) {
		
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				Query<Order> theQuery = currentSession.createQuery("from Order where counter=:c and status=:s", 
																				Order.class);
				theQuery.setParameter("c", counter);
				theQuery.setParameter("s", status);
				
				List<Order> theOrders = theQuery.getResultList();

				return theOrders;
	}

}
