package com.ab.daos;

import java.util.List;

import com.ab.models.Book;

public interface BookDAO {
	
	public List<Book> loadRegisteredBooks();
	public String loadRegisteredBooksString();
	
	public List<Book> searchBookTitle(String title);
	public String searchBookTitleString(String title);
	
	public List<Book> searchBookAuthor(String author);
	public String searchBookAuthorString(String author);
	
	public Book searchBookId(int id);

}
