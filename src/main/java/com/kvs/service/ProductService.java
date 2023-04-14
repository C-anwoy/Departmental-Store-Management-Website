package com.kvs.service;

import java.util.List;

import javax.validation.Valid;

import com.kvs.entity.Product;

public interface ProductService {

	List<Product> findProductByCat(int categoryId);
	
	List<Product> getProducts();

	void saveProduct(Product theProduct);

	Product getProduct(int theId);

	List<Product> findProductByCatAndQty(int categoryId);

}
