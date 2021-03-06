package com.ab.controllers;

import java.util.List;

import com.ab.models.Book;
import com.ab.services.BookService;

public class BookController {
	
	private BookService bookService;

	public BookController(BookService bookService) {

		this.bookService = bookService;
	}
	
	public List<Book> getAllBooks(){
		
		return this.bookService.loadRegisteredBooks();
	}
	
	
	public String getAllBooksString() {
		
		return this.bookService.loadRegisteredBooksString();
		
	}
	
	public List<Book> getBooksByTitle(String title){
		
		return this.bookService.getBooksByTitle(title);
	}
	
	public String getBooksByTitleString(String title) {
		
		return this.bookService.getBooksByTitleString(title);
		
	}

	public List<Book> getBooksByAuthor(String author){
		
		return this.bookService.getBooksByAuthor(author);
	}
	
	
	
	public String getBooksByAuthorString(String author) {
		
		return this.bookService.getBooksByAuthorString(author);
		
	}
	
	public Book getBooksByID(int id){
		
		return this.bookService.getBookByID(id);
	}

}
