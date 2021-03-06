package com.ab.services;

import java.util.List;

import com.ab.daos.BookDAO;
import com.ab.models.Book;

public class BookService {
	
private BookDAO bookDAO;
	

	
	public BookService(BookDAO bookDAO) {
		
		this.bookDAO = bookDAO;
	}
	
	public List<Book> loadRegisteredBooks(){
		
		return this.bookDAO.loadRegisteredBooks();
	}
	
	
	public String loadRegisteredBooksString() {
		
		return this.bookDAO.loadRegisteredBooksString();
		
	}
	
	public List<Book> getBooksByTitle(String title){
		
		return this.bookDAO.searchBookTitle(title);
	}
	
	
	
	public String getBooksByTitleString(String title) {
		
		return this.bookDAO.searchBookTitleString(title);
		
	}
	
	
	public List<Book> getBooksByAuthor(String author){
		
		return this.bookDAO.searchBookAuthor(author);
	}
	
	
	
	public String getBooksByAuthorString(String author) {
		
		return this.bookDAO.searchBookAuthorString(author);
		
	}
	
	
	public Book getBookByID(int id){
		
		return this.bookDAO.searchBookId(id);
	}

}
