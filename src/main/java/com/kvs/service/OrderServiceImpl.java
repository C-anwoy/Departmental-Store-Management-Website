package com.kvs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kvs.dao.OrderDAO;
import com.kvs.entity.OnlineCounter;
import com.kvs.entity.Order;
import com.kvs.entity.OrderedProducts;
import com.kvs.entity.Product;
import com.kvs.entity.ProductsInCart;
import com.kvs.entity.User;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;

	@Override
	@Transactional
	public int saveOrder(Order theOrder) {
		
		int theId = orderDAO.saveOrder(theOrder);
		return theId;
	}
	
	
	@Override
	@Transactional
	public void updateOrder(Order theOrder) {
		
		orderDAO.updateOrder(theOrder);
		
	}

	@Override
	@Transactional
	public Order getOrder(int orderId) {
		
		Order theOrder = orderDAO.getOrder(orderId);
		return theOrder;
	}

	@Override
	@Transactional
	public void saveOrderedProducts(OrderedProducts orderProduct) {
		
		orderDAO.saveOrderedProducts(orderProduct);
	}

	@Override
	@Transactional
	public List<Order> getOrders(User customer) {
		
		List<Order> theOrders = orderDAO.getOrders(customer);
		
		return theOrders;
	}

	@Override
	@Transactional
	public Order getTheOrder(int orderId) {
		
		Order theOrder = orderDAO.getTheOrder(orderId);
		return theOrder;
	}

	@Override
	@Transactional
	public List<Product> getProductsInOrder(Order theOrder) {
		
		List<OrderedProducts> orderProducts = orderDAO.getProductsInOrder(theOrder);
		List<Product> theProducts = new ArrayList<Product>();
		
		for(OrderedProducts p : orderProducts) {
			
			Product pr=p.getProduct();
			
			theProducts.add(pr);
			
		}
		
		return theProducts;
	}
	
	
	@Override
	@Transactional
	public List<OrderedProducts> getOrderedProducts(Order theOrder) {
		
		List<OrderedProducts> orderProducts = orderDAO.getProductsInOrder(theOrder);
		List<Product> theProducts = new ArrayList<Product>();
		
		for(OrderedProducts p : orderProducts) {
			
			Product pr=p.getProduct();
			
			theProducts.add(pr);
			
		}
		
		return orderProducts;
	}

	@Override
	@Transactional
	public List<Order> getOrdersByStatus(String status) {
		
		List<Order> theOrders = orderDAO.getOrdersByStatus(status);
		return theOrders;
	}


	@Override
	@Transactional
	public List<Order> getOrdersByCounterAndStatus(OnlineCounter counter, String status) {
		
		List<Order> theOrders = orderDAO.getOrdersByCounterAndStatus(counter, status);
		return theOrders;
	}
	

}
