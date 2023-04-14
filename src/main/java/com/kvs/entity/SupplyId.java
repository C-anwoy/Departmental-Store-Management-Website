package com.kvs.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

//class for composite primary key
@Embeddable
public class SupplyId implements Serializable {
	
	private int batchNo;
	private Product product;
	private Vendor vendor;
	
	//constructors
	public SupplyId() {
	}

	public SupplyId(int batchNo, Product product, Vendor vendor) {
		super();
		this.batchNo = batchNo;
		this.product = product;
		this.vendor = vendor;
	}

	//getters and setters
	
	public int getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}

	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	public Product getProduct() {
		return product;
	}
	
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
