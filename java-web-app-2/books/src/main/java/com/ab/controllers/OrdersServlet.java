package com.ab.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.daos.BookDAO;
import com.ab.daos.BookDAOImpl;
import com.ab.daos.OrdersDAO;
import com.ab.daos.OrdersDAOImpl;
import com.ab.models.Book;
import com.ab.models.Customer;
import com.ab.models.Order;
import com.ab.services.BookService;
import com.ab.services.OrdersService;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrdersDAO dao = new OrdersDAOImpl();
		
        OrdersService service = new OrdersService(dao);
		
		OrdersController ctrl = new OrdersController(service);
	
	
		
		// This below statement enables session
		HttpSession session = request.getSession(true);
		
		Customer customer = (Customer) session.getAttribute("loggedInCustomer");
		
		List<Order> orders = ctrl.getCustomerOrders(customer.getCustomerId());
		
		// Code to store list of students in a session object
		
		session.setAttribute("customerOrders", orders);
		
		// Redirect the client request to view_students.jsp
		response.sendRedirect("view_orders.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
