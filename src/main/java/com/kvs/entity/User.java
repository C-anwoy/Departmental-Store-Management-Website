package com.kvs.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "username")
	private Integer userName;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;
	
	//added
	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;
	
	//added
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pin")
	private String pin;
	
	@Column(name="state")
	private String state;
	

	//foreign keys
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;
	
	//orders of a customer
	@OneToMany(mappedBy="customer", fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Order> orders;
	
	@OneToMany(mappedBy="customer", fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Sale> sales;

	//products in cart -- many to many relation with extra attribute in join table 
	@OneToMany(mappedBy="primaryKey.customer", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
					CascadeType.REFRESH})	
	private Set<ProductsInCart> productsInCart = new HashSet<ProductsInCart>();
	
	//online_counter_id is a foreign key
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
										CascadeType.REFRESH})
	@JoinColumn(name="online_counter_id")
	private OnlineCounter onlineCounter;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH})
	@JoinColumn(name="offline_counter_id")
	private OfflineCounter offlineCounter;
	
	//godown headed by staff
	@OneToOne(fetch=FetchType.LAZY, mappedBy="incharge", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH})
	private Godown godown;
			
	public User() {
	}

	/*public User(String userName, String password, String firstName, String lastName, String email) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}*/
	
	public User(String password, String firstName, String lastName, String email) {
		//this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	/*public User(String userName, String password, String firstName, String lastName, String email,
			Collection<Role> roles) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roles = roles;
	}*/
	
	public User(String password, String firstName, String lastName, String email,
			Collection<Role> roles) {
		//this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roles = roles;
	}

	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/

	public Integer getUserName() {
		return userName;
	}

	public void setUserName(Integer userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Set<ProductsInCart> getProductsInCart() {
		return productsInCart;
	}

	public void setProductsInCart(Set<ProductsInCart> productsInCart) {
		this.productsInCart = productsInCart;
	}
	
	
	public OnlineCounter getOnlineCounter() {
		return onlineCounter;
	}

	public void setOnlineCounter(OnlineCounter onlineCounter) {
		this.onlineCounter = onlineCounter;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public OfflineCounter getOfflineCounter() {
		return offlineCounter;
	}

	public void setOfflineCounter(OfflineCounter offlineCounter) {
		this.offlineCounter = offlineCounter;
	}

	public Godown getGodown() {
		return godown;
	}

	public void setGodown(Godown godown) {
		this.godown = godown;
	}

	//add a convenience methods
	public void addProductsInCart(ProductsInCart product) {
			
			this.productsInCart.add(product);
		}

	//to String
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", email=" + email + ", street=" + street + ", city=" + city
				+ ", pin=" + pin + ", state=" + state + ", roles=" + roles + ", orders=" + orders + ", sales=" + sales
				+ ", productsInCart=" + productsInCart + ", onlineCounter=" + onlineCounter + ", offlineCounter="
				+ offlineCounter + ", godown=" + godown + "]";
	}
}
