package com.kvs.dao;

import java.util.List;

import com.kvs.entity.Product;
import com.kvs.entity.ProductsInCart;
import com.kvs.entity.ProductsInCartId;
import com.kvs.entity.User;

public interface CartDAO {

	void saveCart(ProductsInCart productInCart);

	ProductsInCart findProductInCart(User customer, Product product);

	List<ProductsInCart> getProductsInCart(User customer);

	void removeProduct(ProductsInCartId primarykey);

	void deleteCartProducts(User customer);

}
