package com.ab.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ab.daos.CustomerDAO;
import com.ab.daos.CustomerDAOImpl;
import com.ab.models.Customer;
import com.ab.services.CustomerService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
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
		
		// Write code to read user's input 
		
		
		String firstName = request.getParameter("firstname");
		
		String lastName = request.getParameter("lastname");
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		String email = request.getParameter("email");
		
		String delivery = request.getParameter("delivery");
		
		
		int i = ctrl.registerCustomer(new Customer(firstName,lastName,username,password,email,delivery));
		
		if(i > 0) {
			
			response.sendRedirect("login.jsp");
		}
		else {
			
			response.sendRedirect("register.jsp");
		}
		
	}

}
