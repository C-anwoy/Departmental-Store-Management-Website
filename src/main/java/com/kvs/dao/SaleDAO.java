package com.kvs.dao;

import java.util.List;

import com.kvs.entity.OfflineCounter;
import com.kvs.entity.Sale;
import com.kvs.entity.SoldProducts;
import com.kvs.entity.User;

public interface SaleDAO {

	int saveSale(Sale theSale);

	Sale getSale(int saleId);

	void saveSoldProducts(SoldProducts soldProduct);

	List<Sale> getSales(User customer);

	Sale getTheSale(int saleId);

	List<SoldProducts> getProductsInSale(Sale theSale);

	List<Sale> getSalesByCounter(OfflineCounter counter);

	void updateSale(Sale theSale);

	List<Sale> getAllSales();

}
