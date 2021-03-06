package com.ab.models;

public class Book {
	
	
	public int id;
	public String title;
	public String author;
	public String isbn;
	public String publisher;
	public String publish_date;
	
	public Book(String title, String author, String isbn, String publisher, String publish_date, int id) {
	super();
	this.title = title;
	this.author = author;
	this.isbn = isbn;
	this.publisher = publisher;
	this.publish_date = publish_date;
	this.id = id;
}

	
	
	public Book(String title, String isbn, String overview, String publisher, String publish_date) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.author = overview;
		this.publisher = publisher;
		this.publish_date = publish_date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getPublish_date() {
		return publish_date;
	}


	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Book [title=" + title + ", isbn=" + isbn + ", overview=" + author + ", publisher=" + publisher
				+ ", publish_date=" + publish_date + "]";
		
	
	}
	
	
	

}
