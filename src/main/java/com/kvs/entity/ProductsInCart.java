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
@Table(name="products_in_cart")
@AssociationOverrides({
	@AssociationOverride(name = "primaryKey.customer", joinColumns=@JoinColumn(name="customer_id")),
	@AssociationOverride(name = "primaryKey.product", joinColumns=@JoinColumn(name="product_id")) })
public class ProductsInCart {

	//composite id key
	private ProductsInCartId primaryKey = new ProductsInCartId();
	
	//additional field
	@Column(name="quantity")
	private int quantity;

	
	
	public ProductsInCart() {
	}

	public ProductsInCart(ProductsInCartId primaryKey, int quantity) {
		super();
		this.primaryKey = primaryKey;
		this.quantity = quantity;
	}

	@EmbeddedId
	public ProductsInCartId getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(ProductsInCartId primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	@Transient
	public User getCustomer() {
		return getPrimaryKey().getCustomer();
	}
	
	public void setCustomer(User customer) {
		getPrimaryKey().setCustomer(customer);
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
