package com.ab.daos;
import java.util.stream.*;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ab.models.Book;

public class BookDAOImpl implements BookDAO {
	
	
	private Connection con;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
	
	
	public BookDAOImpl() {
		
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

	@Override
	public List<Book> loadRegisteredBooks() {
		
		List<Book> books = new ArrayList<>();
		
		try {
			
			this.pst = this.con.prepareStatement("SELECT * from book");
			
			this.rs = this.pst.executeQuery();
			

			while(this.rs.next()) {
				
				Book b = new Book(this.rs.getString("title"),
										this.rs.getString("author"),
										this.rs.getString("ibsn"),
										this.rs.getString("publisher"),
										this.rs.getString("publish_date"),
										this.rs.getInt("book_id")
										);
				
				
			    books.add(b);
			    
			}
			
		}
		catch(SQLException e) {
			System.out.println(e);
			return null;
			
		}
		
		return books;
	}

	@Override
	public String loadRegisteredBooksString() {
		
List<Book> books = this.loadRegisteredBooks();
		
		String booksString = books
			    .stream()
			    .map(b -> "Title: " + b.getTitle() + ", Author: " + b.getAuthor() + ", IBSN: " + b.getIsbn() + ", Publisher: " + b.getPublisher() + ", Publish Date: " + b.getPublish_date() + "<br>" )
			    .collect(Collectors.joining());
		

		
		return booksString;
		
	}

	@Override
	public List<Book> searchBookTitle(String title) {
	
	List<Book> books = new ArrayList<>();
		
		try {
			
			this.pst = this.con.prepareStatement("SELECT * FROM book WHERE TITLE = ? ");
			
			this.pst.setString(1, title);
			
			this.rs = this.pst.executeQuery();
			

			while(this.rs.next()) {
				
				Book b = new Book(this.rs.getString("title"),
										this.rs.getString("author"),
										this.rs.getString("ibsn"),
										this.rs.getString("publisher"),
										this.rs.getString("publish_date"),
										this.rs.getInt("book_id")
										);
				
				
			    books.add(b);
			    
			}
			
		}
		catch(SQLException e) {
			System.out.println(e);
			return null;
			
		}
		
		return books;
	}
	
	public String searchBookTitleString(String title) {
		
		List<Book> books = this.searchBookTitle(title);
				
				String booksString = books
					    .stream()
					    .map(b -> "Title: " + b.getTitle() + ", Author: " + b.getAuthor() + ", IBSN: " + b.getIsbn() + ", Publisher: " + b.getPublisher() + ", Publish Date: " + b.getPublish_date() + "<br>" )
					    .collect(Collectors.joining());
				

				
				return booksString;
				
			}

	@Override
	public List<Book> searchBookAuthor(String author) {
		List<Book> books = new ArrayList<>();
		
		try {
			
			this.pst = this.con.prepareStatement("SELECT * FROM book WHERE author = ? ");
			
			this.pst.setString(1,author);
			
			this.rs = this.pst.executeQuery();
			

			while(this.rs.next()) {
				
				Book b = new Book(this.rs.getString("title"),
										this.rs.getString("author"),
										this.rs.getString("ibsn"),
										this.rs.getString("publisher"),
										this.rs.getString("publish_date"),
										this.rs.getInt("book_id")
										);
				
				
			    books.add(b);
			    
			}
			
		}
		catch(SQLException e) {
			System.out.println(e);
			return null;
			
		}
		
		return books;
	}

	@Override
	public String searchBookAuthorString(String author) {
		List<Book> books = this.searchBookAuthor(author);
		
		String booksString = books
			    .stream()
			    .map(b -> "Title: " + b.getTitle() + ", Author: " + b.getAuthor() + ", IBSN: " + b.getIsbn() + ", Publisher: " + b.getPublisher() + ", Publish Date: " + b.getPublish_date() + "<br>" )
			    .collect(Collectors.joining());
		
		
		return booksString;
	}

	@Override
	public Book searchBookId(int id) {
		try {
			
			this.pst = this.con.prepareStatement("SELECT * FROM book WHERE book_id = ? ");
			
			this.pst.setInt(1, id);
			
			this.rs = this.pst.executeQuery();
			

			this.rs.next();
				
				Book b = new Book(this.rs.getString("title"),
										this.rs.getString("author"),
										this.rs.getString("ibsn"),
										this.rs.getString("publisher"),
										this.rs.getString("publish_date"),
										this.rs.getInt("book_id")
										);
				
				return b;
			
		}
		catch(SQLException e) {
			System.out.println(e);
			return null;
			
		}

	}

	
	
	
}
