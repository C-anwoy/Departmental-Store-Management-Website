package com.kvs.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

//class for composite primary key
@Embeddable
public class OrderedProductsId implements Serializable {
	
	private Order order;
	private Product product;
	
	//constructors
	public OrderedProductsId() {
	}

	public OrderedProductsId(Order order, Product product) {
		super();
		this.order = order;
		this.product = product;
	}

	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, 
						CascadeType.PERSIST, CascadeType.REFRESH})
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
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
