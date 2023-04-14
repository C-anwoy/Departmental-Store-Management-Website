package com.kvs.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="products_in_order")
@AssociationOverrides({
	@AssociationOverride(name = "primaryKey.order", joinColumns=@JoinColumn(name="order_id")),
	@AssociationOverride(name = "primaryKey.product", joinColumns=@JoinColumn(name="product_id")) })
public class OrderedProducts {

	//composite id key
	private OrderedProductsId primaryKey = new OrderedProductsId();
	
	//additional field
	@Column(name="quantity")
	private int quantity;

	//constructors
	
	public OrderedProducts() {
	}
	
	public OrderedProducts(OrderedProductsId primaryKey, int quantity) {
		super();
		this.primaryKey = primaryKey;
		this.quantity = quantity;
	}
	

	@EmbeddedId
	public OrderedProductsId getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(OrderedProductsId primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	@Transient
	public Order getOrder() {
		return getPrimaryKey().getOrder();
	}
	
	public void setOrder(Order order) {
		getPrimaryKey().setOrder(order);
	}
	
	@Transient
	public Product getProduct() {
		return getPrimaryKey().getProduct();
	}
	
	public void setProduct(Product product) {
		getPrimaryKey().setProduct(product);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
