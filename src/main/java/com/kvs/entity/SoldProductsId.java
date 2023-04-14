package com.kvs.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

//class for composite primary key
@Embeddable
public class SoldProductsId implements Serializable {
	
	private Sale sale;
	private Product product;
	
	//constructors
	public SoldProductsId() {
	}

	public SoldProductsId(Sale sale, Product product) {
		super();
		this.sale = sale;
		this.product = product;
	}

	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, 
						CascadeType.PERSIST, CascadeType.REFRESH})
	public Sale getSale() {
		return sale;
	}
	
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	public Product getProduct() {
		return product;
	}
	
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
