package com.kvs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.kvs.validation.ValidEmail;


@Entity
@Table(name = "vendor")
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_id")
	private int id;

	@Column(name = "vendor_name")
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String vendorName;

	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;

	@ValidEmail
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "email")
	private String email;
	
	//no-arg constructor
	public Vendor() {
			
	}

	//getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//to String
	
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", vendorName=" + vendorName + ", street=" + street + ", city=" + city + ", state="
				+ state + ", email=" + email + "]";
	}
	
	

}
