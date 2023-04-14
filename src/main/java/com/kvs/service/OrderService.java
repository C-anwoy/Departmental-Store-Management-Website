package com.kvs.service;

import java.util.List;

import com.kvs.entity.OnlineCounter;
import com.kvs.entity.Order;
import com.kvs.entity.OrderedProducts;
import com.kvs.entity.Product;
import com.kvs.entity.User;

public interface OrderService {

	int saveOrder(Order theOrder);

	Order getOrder(int orderId);

	void saveOrderedProducts(OrderedProducts orderProduct);

	List<Order> getOrders(User customer);

	Order getTheOrder(int orderId);

	List<Product> getProductsInOrder(Order theOrder);

	List<OrderedProducts> getOrderedProducts(Order theOrder);

	List<Order> getOrdersByStatus(String status);

	void updateOrder(Order theOrder);

	List<Order> getOrdersByCounterAndStatus(OnlineCounter counter, String status);

}
