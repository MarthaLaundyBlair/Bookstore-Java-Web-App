package com.ab.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ab.models.Book;
import com.ab.models.Order;

public class OrdersDAOImpl implements OrdersDAO {

	private Connection con;

	private PreparedStatement pst;
	private ResultSet rs;



	public OrdersDAOImpl() {

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

	public List<Order> findCustomerOrders(int customer_id) {

		List<Order> orders = new ArrayList<>();
		Order currentOrder;
		int currentOrderNum = 0;

		try {

			this.pst = this.con.prepareStatement(

					"SELECT O.order_num, O.customer_id, OB.book_id, B.title, B.author, B.ibsn, B.publisher, B.publish_date\r\n"
					+ "FROM Orders O\r\n"
					+ "INNER JOIN Order_Breakdown OB ON O.order_num = OB.order_num\r\n"
					+ "INNER JOIN Book B ON OB.book_id = B.book_id\r\n"
					+ "WHERE O.customer_id = "
					+ customer_id

					);
			
			//this.pst.setInt(1,customer_id);

			this.rs = this.pst.executeQuery();

			this.rs.next();
			currentOrderNum = this.rs.getInt("order_num");
			currentOrder = new Order(
					currentOrderNum,
					this.rs.getInt("customer_id")

					);

			Book b = new Book(this.rs.getString("title"),
					this.rs.getString("author"),
					this.rs.getString("ibsn"),
					this.rs.getString("publisher"),
					this.rs.getString("publish_date"),
					this.rs.getInt("book_id")
					);
			currentOrder.addBookToOrder(b);


			while(this.rs.next()) {

					if (this.rs.getInt("order_num") == currentOrderNum) {

						b = new Book(this.rs.getString("title"),
								this.rs.getString("author"),
								this.rs.getString("ibsn"),
								this.rs.getString("publisher"),
								this.rs.getString("publish_date"),
								this.rs.getInt("book_id")
								);
						currentOrder.addBookToOrder(b);

					}
					else {
						currentOrderNum = this.rs.getInt("order_num");
						orders.add(currentOrder);
						currentOrder = new Order(
								currentOrderNum,
								this.rs.getInt("customer_id")

								);

						b = new Book(this.rs.getString("title"),
								this.rs.getString("author"),
								this.rs.getString("ibsn"),
								this.rs.getString("publisher"),
								this.rs.getString("publish_date"),
								this.rs.getInt("book_id")
								);
						currentOrder.addBookToOrder(b);	

					}

				}
		

			orders.add(currentOrder);

		}
		catch(SQLException e) {
			System.out.println(e);
			return null;

		}

		return orders;
	}




}
