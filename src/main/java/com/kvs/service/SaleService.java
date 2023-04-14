package com.kvs.service;

import java.util.List;

import com.kvs.entity.OfflineCounter;
import com.kvs.entity.OnlineCounter;
import com.kvs.entity.Order;
import com.kvs.entity.OrderedProducts;
import com.kvs.entity.Product;
import com.kvs.entity.Sale;
import com.kvs.entity.SoldProducts;
import com.kvs.entity.User;

public interface SaleService {
	
	int saveSale(Sale theSale);

	Sale getSale(int saleId);

	void saveSoldProducts(SoldProducts soldProduct);

	List<Sale> getSales(User customer);
	
	List<Sale> getAllSales();

	Sale getTheSale(int saleId);

	List<Product> getProductsInSale(Sale theSale);

	List<SoldProducts> getSoldProducts(Sale theSale);

	List<Sale> getSalesByCounter(OfflineCounter counter);

	void updateSale(Sale theSale);

}
