package com.kvs.entity;

public class ProductWithTotal {
	
	private ProductsInCart p;
	
	private int total;
	
	public ProductWithTotal(ProductsInCart p, int total) {
		super();
		this.p = p;
		this.total = total;
	}

	public ProductsInCart getP() {
		return p;
	}

	public void setP(ProductsInCart p) {
		this.p = p;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	

}
