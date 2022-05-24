package com.ab.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
	
	private int order_num;
	private int customer_id;
	private List<Book> booksOrdered;
	
	
	
	public Order(int order_num, int customer_id, List<Book> booksOrdered) {
		super();
		this.order_num = order_num;
		this.customer_id = customer_id;
		this.booksOrdered = booksOrdered;
	}
	
	
	public Order(int order_num, int customer_id) {
		super();
		this.order_num = order_num;
		this.customer_id = customer_id;
		this.booksOrdered = new ArrayList<>();
	}
	
	
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public List<Book> getBooksOrdered() {
		return booksOrdered;
	}
	public void setBookOrdered(List<Book> booksOrdered) {
		this.booksOrdered = booksOrdered;
	}


	@Override
	public String toString() {
		return "Order [order_num=" + order_num + ", customer_id=" + customer_id + ", books_ordered=" + booksOrdered
				+ "]";
	}
	
	public void addBookToOrder(Book book) {
		
		this.booksOrdered.add(book);
		
		
	}
	
	public String orderBooksString() {
		
		String booksString = this.booksOrdered
			    .stream()
			    .map(b -> "Title: " + b.getTitle() + ", Author: " + b.getAuthor() + ", IBSN: " + b.getIsbn() + ", Publisher: " + b.getPublisher() + ", Publish Date: " + b.getPublish_date() + "<br>" )
			    .collect(Collectors.joining());
		
		
		return booksString;
	}
	
	
	

}
