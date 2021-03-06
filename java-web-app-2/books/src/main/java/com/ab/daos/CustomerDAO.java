package com.ab.daos;

import java.util.ArrayList;
import java.util.List;

import com.ab.models.Book;
import com.ab.models.Customer;

public interface CustomerDAO {

		public int register(Customer c);
		public Customer login(String username, String password);
		
		public void updateFirstName(Customer c, String firstname);
		public void updateLastName(Customer c, String lastname);
		public void updateUsername(Customer c, String username);
		public void updatePassword(Customer c, String passwordname);
		public void updateAddress(Customer c, String address);
		public void updateEmail(Customer c, String email);
		
		public void submitOrder(Customer c, ArrayList<Book> booksOrdered);
		
	
}
