package com.kvs.dao;

import java.util.List;

import com.kvs.entity.Product;

public interface ProductDAO {
	
	List<Product> findProductbyCat(int categoryId);
	
	List<Product> getProducts();

	void saveProduct(Product theProduct);

	Product getProduct(int theId);

	List<Product> findProductbyCatAndQty(int categoryId);


}
