package com.ab.controllers;

import java.util.ArrayList;

import com.ab.models.Book;
import com.ab.models.Customer;
import com.ab.services.CustomerService;

public class CustomerController {
	
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {

		this.customerService = customerService;
	}
	
	public int registerCustomer(Customer c) {
		
		return this.customerService.registerCustomer(c);
	}
			
			
	public Customer loginCustomer(String username,String password) {
		
		return this.customerService.customerLogin(username, password);
	}

	////////////////////////////////////////////////////
	
	public void updateFirstName(Customer c, String firstname) {
		
		 this.customerService.updateFirstName(c, firstname);
			
		}
	
	public void updateLastName(Customer c, String lastname) {
		
		 this.customerService.updateLastName(c, lastname);
			
		}
	
	public void updateUsername(Customer c, String username) {
		
		 this.customerService.updateUsername(c, username);
			
		}
	
	public void updatePassword(Customer c, String password) {
		
		 this.customerService.updatePassword(c, password);
			
		}
	
	public void updateAddress(Customer c, String address) {
		
		 this.customerService.updateAddress(c, address);
			
		}
	public void updateEmail(Customer c, String email) {
		
		 this.customerService.updateEmail(c, email);
			
		}
	//////////////////////////////////////////////////////////
	
	public void submitOrder(Customer c, ArrayList<Book> booksOrdered) {
		
		this.customerService.submitOrder(c, booksOrdered);
	}
	
}
