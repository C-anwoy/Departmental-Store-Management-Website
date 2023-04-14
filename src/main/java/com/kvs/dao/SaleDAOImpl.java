package com.kvs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvs.entity.OfflineCounter;
import com.kvs.entity.Sale;
import com.kvs.entity.SoldProducts;
import com.kvs.entity.User;

@Repository
public class SaleDAOImpl implements SaleDAO {
	
	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveSale(Sale theSale) {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
						
				// save order
				int id = ((Integer)currentSession.save(theSale)).intValue();
				
				return id;
	}

	@Override
	public Sale getSale(int saleId) {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
						
				//retrieve from database using primary key
				Sale theSale=currentSession.get(Sale.class, saleId);
								
				//return the results
				return theSale;
	}

	@Override
	public void saveSoldProducts(SoldProducts soldProduct) {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
				
				// save order
				currentSession.save(soldProduct);

	}

	@Override
	public List<Sale> getSales(User customer) {
		
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//create a query
		Query<Sale> theQuery=currentSession.createQuery("from Sale where customer=:c", Sale.class);
		theQuery.setParameter("c", customer);
		
		//execute query and get result list
		List<Sale> theSales = theQuery.getResultList();
		
		//return the results
		return theSales;
	}

	@Override
	public Sale getTheSale(int saleId) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
						
		//retrieve from database using primary key
		Sale theSale=currentSession.get(Sale.class, saleId);
								
		//return the results
		return theSale;
	}

	@Override
	public List<SoldProducts> getProductsInSale(Sale theSale) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<SoldProducts> theQuery = currentSession.createQuery("from SoldProducts where primaryKey.sale=:s", 
																	SoldProducts.class);
		theQuery.setParameter("s", theSale);
		
		List<SoldProducts> soldProducts = theQuery.getResultList();

		return soldProducts;
	}

	@Override
	public List<Sale> getSalesByCounter(OfflineCounter counter) {
		
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				Query<Sale> theQuery = currentSession.createQuery("from Sale where counter=:c", 
																	Sale.class);
				theQuery.setParameter("c", counter);
				
				List<Sale> theSales = theQuery.getResultList();

				return theSales;
	}

	@Override
	public void updateSale(Sale theSale) {
		
				//get the current hibernate session
				Session currentSession=sessionFactory.getCurrentSession();
						
				// update order
				currentSession.saveOrUpdate(theSale);

	}

	@Override
	public List<Sale> getAllSales() {
		
				//get the current hibernate session
				Session currentSession= sessionFactory.getCurrentSession();
				
				//create a query
				Query<Sale> theQuery=currentSession.createQuery("from Sale", Sale.class);
			
				
				//execute query and get result list
				List<Sale> theSales = theQuery.getResultList();
				
				//return the results
				return theSales;
	}

}
