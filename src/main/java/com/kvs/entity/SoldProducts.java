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
@Table(name="products_in_sale")
@AssociationOverrides({
	@AssociationOverride(name = "primaryKey.sale", joinColumns=@JoinColumn(name="sale_id")),
	@AssociationOverride(name = "primaryKey.product", joinColumns=@JoinColumn(name="product_id")) })
public class SoldProducts {

	//composite id key
	private SoldProductsId primaryKey = new SoldProductsId();
	
	//additional field
	@Column(name="quantity")
	private int quantity;

	//constructors
	
	public SoldProducts() {
	}
	
	public SoldProducts(SoldProductsId primaryKey, int quantity) {
		super();
		this.primaryKey = primaryKey;
		this.quantity = quantity;
	}
	

	@EmbeddedId
	public SoldProductsId getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(SoldProductsId primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	@Transient
	public Sale getSale() {
		return getPrimaryKey().getSale();
	}
	
	public void setSale(Sale sale) {
		getPrimaryKey().setSale(sale);
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
