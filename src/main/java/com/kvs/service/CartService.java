package com.kvs.service;

import java.util.List;

import com.kvs.entity.Product;
import com.kvs.entity.ProductsInCart;
import com.kvs.entity.ProductsInCartId;
import com.kvs.entity.User;

public interface CartService {

	void saveCart(ProductsInCart productInCart);
	
	ProductsInCart findProductInCart(User customer, Product product );
	
	List<Product> getProductsInCart(User customer);

	List<ProductsInCart> getCartProducts(User customer);

	void removeProduct(ProductsInCartId primarykey);

	void deleteCartProducts(User customer);

}
