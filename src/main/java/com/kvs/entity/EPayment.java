package com.kvs.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="e_payment")
public class EPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int id;

	@Column(name="amount")
	private int totalAmount;
	
	@Column(name="payment_date")
	private Date paymentDate;
	
	@Column(name = "payment_status")
	private String status;
	
	@OneToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH})
	@JoinColumn(name="order_id")
	private Order order;
	
	@OneToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH})
	@JoinColumn(name="sale_id")
	private Sale sale;


	//constructors
	
	public EPayment() {
	}

	public EPayment(int totalAmount, Date paymentDate, String status, Order order) {
		super();
		this.totalAmount = totalAmount;
		this.paymentDate = paymentDate;
		this.status = status;
		this.order = order;
	}
	
	public EPayment(int totalAmount, Date paymentDate, String status, Sale sale) {
		super();
		this.totalAmount = totalAmount;
		this.paymentDate = paymentDate;
		this.status = status;
		this.sale = sale;
	}

	//getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	//to String
	
	@Override
	public String toString() {
		return "EPayment [id=" + id + ", totalAmount=" + totalAmount + ", paymentDate=" + paymentDate + ", status="
				+ status + ", order=" + order + ", sale=" + sale + "]";
	}
	
}
