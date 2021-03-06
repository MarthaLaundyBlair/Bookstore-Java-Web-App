package com.ab.services;

import java.util.ArrayList;
import java.util.List;

import com.ab.daos.CustomerDAO;
import com.ab.models.Book;
import com.ab.models.Customer;

public class CustomerService {
	
	
	
	private CustomerDAO customerDAO;
	
	
	// Code to write DI using constructor 
	
	public CustomerService(CustomerDAO customerDAO) {
		
		this.customerDAO = customerDAO;
	}
	
	
	// Write some business methods
	
	public int registerCustomer(Customer c) {
		
		// As part of registration you may consider writing some code to encrypt user password
		return this.customerDAO.register(c);
		
	}
	
	
	public Customer customerLogin(String username, String password) {
		
		
		return this.customerDAO.login(username, password);
		
	}
	
	////////////////////////////////////////////
	
	public void updateFirstName(Customer c, String firstname) {
		
	 this.customerDAO.updateFirstName(c, firstname);
		
	}

	public void updateLastName(Customer c, String lastname) {
		
		 this.customerDAO.updateLastName(c, lastname);
			
		}
	
	public void updateUsername(Customer c, String username) {
		
		 this.customerDAO.updateUsername(c, username);
			
		}
	
	public void updatePassword(Customer c, String password) {
		
		 this.customerDAO.updatePassword(c, password);
			
		}
	
	public void updateAddress(Customer c, String address) {
		
		 this.customerDAO.updateAddress(c, address);
			
		}
	public void updateEmail(Customer c, String email) {
		
		 this.customerDAO.updateEmail(c, email);
			
		}
	
	/////////////////////////////////////////
	
	public void submitOrder(Customer c, ArrayList<Book> booksOrdered) {
		
		this.customerDAO.submitOrder(c, booksOrdered);
	}
	
	
}