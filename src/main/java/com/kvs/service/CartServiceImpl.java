package com.kvs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kvs.dao.CartDAO;
import com.kvs.dao.ProductDAO;
import com.kvs.entity.Product;
import com.kvs.entity.ProductsInCart;
import com.kvs.entity.ProductsInCartId;
import com.kvs.entity.User;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public void saveCart(ProductsInCart productInCart) {

		cartDAO.saveCart(productInCart);
	}

	@Override
	@Transactional
	public ProductsInCart findProductInCart(User customer, Product product) {
		return cartDAO.findProductInCart(customer, product);
	}

	@Override
	@Transactional
	public List<Product> getProductsInCart(User customer) {
		
		List<ProductsInCart> cartProducts = cartDAO.getProductsInCart(customer);
		List<Product> theProducts = new ArrayList<Product>();
		
		for(ProductsInCart p : cartProducts) {
			
			Product pr=p.getProduct();
			
			theProducts.add(pr);
			
		}
		
		return theProducts;
	}
	
	
	@Override
	@Transactional
	public List<ProductsInCart> getCartProducts(User customer) {
		
		List<ProductsInCart> cartProducts = cartDAO.getProductsInCart(customer);
		List<Product> theProducts = new ArrayList<Product>();
		
		for(ProductsInCart p : cartProducts) {
			
			Product pr=p.getProduct();
			
			theProducts.add(pr);
			
		}
		
		return cartProducts;
	}

	@Override
	@Transactional
	public void removeProduct(ProductsInCartId primarykey) {
		
		cartDAO.removeProduct(primarykey);
		
	}

	@Override
	@Transactional
	public void deleteCartProducts(User customer) {
		
		cartDAO.deleteCartProducts(customer);
		
	}

}
