package com.ab.models;

public class Customer {
	
	private int customerId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String deliveryAdress;
	
	
	public Customer() {}


	public Customer(int customerId, String firstName, String lastName, String username, String password, String email,
			String deliveryAdress) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.deliveryAdress = deliveryAdress;
	}

	public Customer(String firstName, String lastName, String username, String password, String email,
			String deliveryAdress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.deliveryAdress = deliveryAdress;
	}

	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDeliveryAdress() {
		return deliveryAdress;
	}


	public void setDeliveryAdress(String deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + ", email=" + email + ", deliveryAdress="
				+ deliveryAdress + "]";
	}
	
	
	
	
	
	
}


