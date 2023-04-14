package com.kvs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kvs.dao.ProductDAO;
import com.kvs.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDao;
	
	@Override
	@Transactional
	public List<Product> findProductByCat(int categoryId) {
		// check the database
		return productDao.findProductbyCat(categoryId);
			}
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		
		return productDao.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product theProduct) {
		
		productDao.saveProduct(theProduct);
		
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		
		Product theProduct= productDao.getProduct(theId);
		return theProduct;
		
	}

	@Override
	@Transactional
	public List<Product> findProductByCatAndQty(int categoryId) {
		
		return productDao.findProductbyCatAndQty(categoryId);
	}

	
}

