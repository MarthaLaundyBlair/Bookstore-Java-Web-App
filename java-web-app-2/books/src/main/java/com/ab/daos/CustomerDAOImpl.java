package com.ab.daos;

//change this bit!!!
import java.util.*;

import com.ab.models.Book;
import com.ab.models.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO{
	
	private Connection con;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
	
	
	public CustomerDAOImpl() {
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				
				this.con = DriverManager.getConnection("jdbc:mysql://localhost/books","root",""); 
				
				
			}
			catch(ClassNotFoundException e) {
				
				System.out.println(e);
				
			}
			catch(SQLException e) {
				
				System.out.println(e);
				
			}
			
		}
	

	public int register(Customer c) {
		
		try {
			
			
			this.pst = this.con.prepareStatement("INSERT into customer(firstname,lastname,username, password, email, delivery) VALUES(?,?,?,?,?,?)");
			
			this.pst.setString(1, c.getFirstName());
			this.pst.setString(2, c.getLastName());
			this.pst.setString(3, c.getUsername());
			this.pst.setString(4, c.getPassword());
			this.pst.setString(5, c.getEmail());
			this.pst.setString(6, c.getDeliveryAdress());
			
			//String query = "CREATE table basket_customer_" + c.getUsername() + "(id int AUTO_INCREMENT PRIMARY KEY, title varchar(50))";
			//this.pst = this.con.prepareStatement(query);
	
			
			int i = this.pst.executeUpdate();
			
			return i;
			
			
			
			
		}
		catch(SQLException e) {
			
			System.out.println(e);
			return -1;
			
		}
		
	}
	
public Customer login(String username, String password) {
		
		
		try {
			
		  this.pst = this.con.prepareStatement("SELECT * from customer WHERE username = ? and password = ? " );
		  
		  
		  this.pst.setString(1, username);
		  this.pst.setString(2, password);
		  
		  
		  this.rs = this.pst.executeQuery();
		  
		  
		  if(rs.next()) {
			  Customer c = new Customer(rs.getInt("customer_id"),
					  					rs.getString(2),
					  					rs.getString(3),
					  					rs.getString(4),
					  					rs.getString(5),
					  					rs.getString(6),
					  					rs.getString(7)
					  				  );
			  
			  return c;
		  }
			
		}
		catch(SQLException e) {
			
			System.out.println(e);
			return null;
		}
		
		return null;
		
	}

	

public void updateFirstName(Customer c, String firstname) {
	c.setFirstName(firstname);
	
	
	try {
		
		  this.pst = this.con.prepareStatement("UPDATE customer SET firstname = ? WHERE customer_id = ?; " );
		  
		  
		  this.pst.setString(1, firstname);
		  this.pst.setInt(2, c.getCustomerId());
		  
		  
		  int i = this.pst.executeUpdate();
		  
			
		}
		catch(SQLException e) {
			
			System.out.println(e);

		}
	
	
		
	
}


@Override
public void updateLastName(Customer c, String lastname) {
c.setLastName(lastname);
	
	
	try {
		
		  this.pst = this.con.prepareStatement("UPDATE customer SET lastname = ? WHERE customer_id = ?; " );
		  
		  
		  this.pst.setString(1, lastname);
		  this.pst.setInt(2, c.getCustomerId());
		  
		  
		  int i = this.pst.executeUpdate();
		  
			
		}
		catch(SQLException e) {
			
			System.out.println(e);

		}
	
}


@Override
public void updateUsername(Customer c, String username) {
c.setUsername(username);
	
	
	try {
		
		  this.pst = this.con.prepareStatement("UPDATE customer SET username = ? WHERE customer_id = ?; " );
		  
		  
		  this.pst.setString(1, username);
		  this.pst.setInt(2, c.getCustomerId());
		  
		  
		  int i = this.pst.executeUpdate();
		  
			
		}
		catch(SQLException e) {
			
			System.out.println(e);

		}
	
}


@Override
public void updatePassword(Customer c, String password) {
	c.setPassword(password);
	
	try {
		
		  this.pst = this.con.prepareStatement("UPDATE customer SET password = ? WHERE customer_id = ?; " );
		  
		  
		  this.pst.setString(1, password);
		  this.pst.setInt(2, c.getCustomerId());
		  
		  
		  int i = this.pst.executeUpdate();
		  
			
		}
		catch(SQLException e) {
			
			System.out.println(e);

		}
}


@Override
public void updateAddress(Customer c, String address) {
c.setDeliveryAdress(address);
	
	
	try {
		
		  this.pst = this.con.prepareStatement("UPDATE customer SET delivery = ? WHERE customer_id = ?; " );
		  
		  
		  this.pst.setString(1, address);
		  this.pst.setInt(2, c.getCustomerId());
		  
		  
		  int i = this.pst.executeUpdate();
		  
			
		}
		catch(SQLException e) {
			
			System.out.println(e);

		}
	
}


@Override
public void updateEmail(Customer c, String email) {
c.setEmail(email);
	
	
	try {
		
		  this.pst = this.con.prepareStatement("UPDATE customer SET email = ? WHERE customer_id = ?; " );
		  
		  
		  this.pst.setString(1, email);
		  this.pst.setInt(2, c.getCustomerId());
		  
		  
		  int i = this.pst.executeUpdate();
		  
			
		}
		catch(SQLException e) {
			
			System.out.println(e);

		}
	
	
}


@Override
public void submitOrder(Customer c, ArrayList<Book> booksOrdered) {
	
	try {
		
		
		this.pst = this.con.prepareStatement("INSERT into Orders (customer_id) VALUES(?)");
		this.pst.setInt(1, c.getCustomerId());	
		this.pst.executeUpdate();
		
		
		 this.pst = this.con.prepareStatement("SELECT * from Orders WHERE customer_id = ? ORDER BY order_num DESC" );
		 this.pst.setInt(1, c.getCustomerId());
		 this.rs = this.pst.executeQuery();
		  
		  
		 rs.next();
		 int order_id = rs.getInt("order_num");
		 
		 for (Book b: booksOrdered) {
			 
			 this.pst = this.con.prepareStatement("INSERT into Order_Breakdown (order_num, book_id) VALUES(?, ?)");
			 this.pst.setInt(1, order_id);	
			 this.pst.setInt(2, b.getId());	
			 this.pst.executeUpdate();
			 
		 }
		 

		
	}
	catch(SQLException e) {
		
		System.out.println(e);
		
		
	}
	
}

}



