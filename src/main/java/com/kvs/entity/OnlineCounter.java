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

@Entity
@Table(name="online_sales_counter")
public class OnlineCounter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="online_counter_id")
	private int id;
	
	@Column(name="total_online_sale")
	private int totalSale;
	
	//orders in one counter
	@OneToMany(mappedBy="counter", fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, 
																CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Order> orders;
	
	//staffs in one counter
	@OneToMany(mappedBy="onlineCounter", fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, 
																	CascadeType.PERSIST, CascadeType.REFRESH})
	private List<User> staffs;
	
	//no-arg constructor
	public OnlineCounter() {
			
	}

	//getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(int totalSale) {
		this.totalSale = totalSale;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public List<User> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<User> staffs) {
		this.staffs = staffs;
	}
	
	
	
	//to String
	
	@Override
	public String toString() {
		return "OnlineCounter [id=" + id + ", totalSale=" + totalSale + ", orders=" + orders + ", staffs=" + staffs
				+ "]";
	}

	
	
}
