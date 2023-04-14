package com.kvs.entity;

import java.util.List;

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
@Table(name="godown")
public class Godown {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="godown_id")
	private int id;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pin")
	private String pin;
	
	@Column(name="state")
	private String state;
	
	@Column(name="phone")
	private String phone;
	
	//incharge_id is a foreign key in godown relation
	
	@OneToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
						CascadeType.REFRESH})
	@JoinColumn(name="incharge_id")
	private User incharge;
	
	//products in a godown
	@OneToMany(mappedBy="godown", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
											CascadeType.REFRESH})
	private List<Product> products;
	
	//no-arg constructor
	public Godown() {
		
	}

	//getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getIncharge() {
		return incharge;
	}

	public void setIncharge(User incharge) {
		this.incharge = incharge;
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
		return "Godown [id=" + id + ", street=" + street + ", city=" + city + ", pin=" + pin + ", state=" + state
				+ ", phone=" + phone + ", incharge=" + incharge + ", products=" + products + "]";
	}
		

}
