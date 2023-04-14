package com.kvs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="categories")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private int id;
	
	@Column(name="cat_name")
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String catName;
	
	//products of one category
	@OneToMany(fetch = FetchType.LAZY, mappedBy="category", cascade= CascadeType.ALL)
	private List<Product> products;
	
	//no-arg constructor
	public Category() {
		
	}

	//getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
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
		return "Category [id=" + id + ", catName=" + catName + ", products=" + products + "]";
	}
	
	
	
}
