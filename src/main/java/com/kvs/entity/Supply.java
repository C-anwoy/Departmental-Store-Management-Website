package com.kvs.entity;

import java.sql.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="supply")
@AssociationOverrides({
	@AssociationOverride(name = "primaryKey.batchNo", joinColumns=@JoinColumn(name="batchNo")),
	@AssociationOverride(name = "primaryKey.vendor", joinColumns=@JoinColumn(name="vendor_id")),
	@AssociationOverride(name = "primaryKey.product", joinColumns=@JoinColumn(name="product_id")) })
public class Supply {

	//composite id key
	private SupplyId primaryKey = new SupplyId();
	
	//additional fields
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="supplyDate")
	private Date supplyDate;
	
	@Column(name="expiryDate")
	private Date expiryDate;

	//constructors
	
	public Supply() {
	}
	
	
	public Supply(SupplyId primaryKey, int quantity, Date supplyDate, Date expiryDate) {
		super();
		this.primaryKey = primaryKey;
		this.quantity = quantity;
		this.supplyDate = supplyDate;
		this.expiryDate = expiryDate;
	}


	@EmbeddedId
	public SupplyId getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(SupplyId primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	@Transient
	public int getBatchNo() {
		return getPrimaryKey().getBatchNo();
	}
	
	public void setBatchNo(int batchNo) {
		getPrimaryKey().setBatchNo(batchNo);
	}
	
	@Transient
	public Vendor getVendor() {
		return getPrimaryKey().getVendor();
	}
	
	public void setVendor(Vendor vendor) {
		getPrimaryKey().setVendor(vendor);
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


	public Date getSupplyDate() {
		return supplyDate;
	}


	public void setSupplyDate(Date supplyDate) {
		this.supplyDate = supplyDate;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
}
