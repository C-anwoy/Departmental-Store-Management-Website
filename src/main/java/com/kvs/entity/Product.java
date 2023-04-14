package com.kvs.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_description")
	private String productDes;
	
	
	//category_id is a foreign key in product relation
	
	@ManyToOne(fetch = FetchType.EAGER,cascade= {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="category_id")
	private Category category;
	
	//brand_id is a foreign key in product relation
	
	@ManyToOne(fetch = FetchType.EAGER,cascade= {CascadeType.DETACH, CascadeType.MERGE, 
												CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@Column(name="mrp")
	private String mRP;
	
	@Column(name="quantity_in_stock")
	private int stock;
	
	//godown_id is a foreign key in product relation
	
	@ManyToOne(fetch = FetchType.LAZY,cascade= {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="godown_id")
	private Godown godown;
	
	//products in order -- many to many relation with extra attribute in join table 
	@OneToMany(mappedBy="primaryKey.product", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH})	
	private Set<OrderedProducts> orderedProducts = new HashSet<OrderedProducts>();
	
	//products in cart -- many to many relation with extra attribute in join table 
		@OneToMany(mappedBy="primaryKey.product", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
				CascadeType.REFRESH})	
		private Set<ProductsInCart> productsInCart = new HashSet<ProductsInCart>();
	
	//no-arg constructor
	public Product() {
		
	}
	
	

	public Product(String productName, String productDes, Category category, Brand brand, String mRP) {
		super();
		this.productName = productName;
		this.productDes = productDes;
		this.category = category;
		this.brand = brand;
		this.mRP = mRP;
	}
	
	public Product(String productName, String productDes, Category category, Brand brand, String mRP, int stock,
			Godown godown) {
		super();
		this.productName = productName;
		this.productDes = productDes;
		this.category = category;
		this.brand = brand;
		this.mRP = mRP;
		this.stock = stock;
		this.godown = godown;
	}



	//getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getMRP() {
		return mRP;
	}

	public void setMRP(String mRP) {
		this.mRP = mRP;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Godown getGodown() {
		return godown;
	}

	public void setGodown(Godown godown) {
		this.godown = godown;
	}

	//@OneToMany(mappedBy="primaryKey.product", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
			//CascadeType.REFRESH})	
	public Set<OrderedProducts> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(Set<OrderedProducts> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	
	
	public Set<ProductsInCart> getProductsInCart() {
		return productsInCart;
	}

	public void setProductsInCart(Set<ProductsInCart> productsInCart) {
		this.productsInCart = productsInCart;
	}

	//add a convenience methods
	
	public void addOrderedProducts(OrderedProducts product) {
		
		this.orderedProducts.add(product);
	}

	public void addProductsInCart(ProductsInCart product) {
		
		this.productsInCart.add(product);
	}

	//to String
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productDes=" + productDes + ", category="
				+ category + ", brand=" + brand + ", MRP=" + mRP + ", stock=" + stock + ", godown=" + godown
				+ ", orderedProducts=" + orderedProducts + ", productsInCart=" + productsInCart + "]";
	}
	
		
}
