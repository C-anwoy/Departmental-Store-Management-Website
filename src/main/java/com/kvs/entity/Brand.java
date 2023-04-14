package com.kvs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="brand")
public class Brand {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="brand_id")
	private int id;
	
	@Column(name="brand_name")
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String brandName;
	
	//products of one brand
	@OneToMany(mappedBy="brand", cascade= CascadeType.ALL)
	private List<Product> products;
	
	//no-arg constructor
	public Brand() {
		
	}

	//getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	//to String
	@Override
	public String toString() {
		return "Brand [id=" + id + ", brandName=" + brandName + ", products=" + products + "]";
	}
	
	
}
