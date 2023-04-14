package com.kvs.entity;

import java.sql.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="offline_sale")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sale_id")
	private int id;

	@Column(name = "sale_description")
	private String description;

	@Column(name="sale_date")
	private Date saleDate;
	
	@Column(name="payment_mode")
	private String paymentMode;
	
	@Column(name="total_amount")
	private int totalAmount;
	
	//customer_id is a foreign key in offline_sales relation
	
	@OneToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
				CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private User customer;
	
	//online_counter_id is a foreign key in offline_sales relation
	
	@OneToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH})
	@JoinColumn(name="offline_counter_id")
	private OfflineCounter counter;
	
	//products in sale -- many to many relation with extra attribute in join table 
	@OneToMany(mappedBy="primaryKey.sale", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
				CascadeType.REFRESH})
	private Set<SoldProducts> soldProducts = new HashSet<SoldProducts>();
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="sale", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH})
	
	private EPayment epayment;

	//no-arg constructor
	public Sale() {
			
	}
	
	public Sale(String description, Date saleDate, String paymentMode, int totalAmount, User customer) {
		super();
		this.description = description;
		this.saleDate = saleDate;
		this.paymentMode = paymentMode;
		this.totalAmount = totalAmount;
		this.customer = customer;
	}
	
		
	public Sale(String description, Date saleDate, String paymentMode, int totalAmount, User customer,
			OfflineCounter counter) {
		super();
		this.description = description;
		this.saleDate = saleDate;
		this.paymentMode = paymentMode;
		this.totalAmount = totalAmount;
		this.customer = customer;
		this.counter = counter;
	}

	//getters and setters
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public OfflineCounter getCounter() {
		return counter;
	}

	public void setCounter(OfflineCounter counter) {
		this.counter = counter;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Set<SoldProducts> getSoldProducts() {
		return soldProducts;
	}

	public void setSoldProducts(Set<SoldProducts> soldProducts) {
		this.soldProducts = soldProducts;
	}

	public EPayment getEpayment() {
		return epayment;
	}

	public void setEpayment(EPayment epayment) {
		this.epayment = epayment;
	}


	//to String
	
	@Override
	public String toString() {
		return "Sale [id=" + id + ", description=" + description + ", saleDate=" + saleDate + ", paymentMode="
				+ paymentMode + ", totalAmount=" + totalAmount + ", customer=" + customer + ", counter=" + counter
				+ ", soldProducts=" + soldProducts + "]";
	}

	
	

}
