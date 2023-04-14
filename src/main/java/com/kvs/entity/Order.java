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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="online_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;

	@Column(name = "order_status")
	private String status;

	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="payment_mode")
	private String paymentMode;
	
	@Column(name="total_amount")
	private int totalAmount;
	
	//customer_id is a foreign key in online_order relation
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
									CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private User customer;
	
	//online_counter_id is a foreign key in online_order relation
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
									CascadeType.REFRESH})
	@JoinColumn(name="online_counter_id")
	private OnlineCounter counter;
	
	//products in order -- many to many relation with extra attribute in join table 
	@OneToMany(mappedBy="primaryKey.order", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH})
	private Set<OrderedProducts> orderedProducts = new HashSet<OrderedProducts>();
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="order", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH})
	private EPayment epayment;

	//no-arg constructor
	public Order() {
		
	}


	public Order(String status,Date orderDate, String paymentMode, int totalAmount, User customer) {
		super();
		this.status= status;
		this.orderDate = orderDate;
		this.paymentMode = paymentMode;
		this.totalAmount = totalAmount;
		this.customer = customer;
	}



	//getters and setters
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public User getCustomer() {
		return customer;
	}


	public void setCustomer(User customer) {
		this.customer = customer;
	}


	public OnlineCounter getCounter() {
		return counter;
	}


	public void setCounter(OnlineCounter counter) {
		this.counter = counter;
	}
	
	//@OneToMany(mappedBy="primaryKey.order", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
														//CascadeType.REFRESH})	
	public Set<OrderedProducts> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(Set<OrderedProducts> products) {
		this.orderedProducts = products;
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
	

	public EPayment getEpayment() {
		return epayment;
	}


	public void setEpayment(EPayment epayment) {
		this.epayment = epayment;
	}


	
	//add a convenience methods
	

	public void addOrderedProducts(OrderedProducts product) {
		
		this.orderedProducts.add(product);
	}
		
		

	//to String
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", orderDate=" + orderDate + ", paymentMode=" + paymentMode
				+ ", totalAmount=" + totalAmount + ", customer=" + customer + ", counter=" + counter
				+ ", orderedProducts=" + orderedProducts + "]";
	}



	
}
