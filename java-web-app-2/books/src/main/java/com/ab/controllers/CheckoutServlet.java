package com.ab.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.daos.BookDAO;
import com.ab.daos.BookDAOImpl;
import com.ab.daos.CustomerDAO;
import com.ab.daos.CustomerDAOImpl;
import com.ab.models.Book;
import com.ab.models.Customer;
import com.ab.services.BookService;
import com.ab.services.CustomerService;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   CustomerDAO dao = new CustomerDAOImpl();
			
	        CustomerService service = new CustomerService(dao);
			
			CustomerController ctrl = new CustomerController(service);
			
			// This below statement enables session
			HttpSession session = request.getSession(true);
		
			
			ArrayList<Book> basket = (ArrayList<Book>) session.getAttribute("basket");
			Customer loggedInCustomer = (Customer) session.getAttribute("loggedInCustomer");
			
			if (basket.isEmpty() == false) {
				ctrl.submitOrder(loggedInCustomer, basket);
				basket.clear();
			}
			
			response.sendRedirect("welcome.jsp");
				
				
	}

}
