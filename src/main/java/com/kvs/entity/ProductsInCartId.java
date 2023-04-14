package com.kvs.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

//class for composite primary key
@Embeddable
public class ProductsInCartId implements Serializable {
	
	private User customer;
	private Product product;
	
	
	public ProductsInCartId(User customer, Product product) {
		super();
		this.customer = customer;
		this.product = product;
	}

	public ProductsInCartId() {
	}

	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, 
						CascadeType.PERSIST, CascadeType.REFRESH})
	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
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
