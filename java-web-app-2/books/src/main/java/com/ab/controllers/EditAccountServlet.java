package com.ab.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.daos.CustomerDAO;
import com.ab.daos.CustomerDAOImpl;
import com.ab.models.Customer;
import com.ab.services.CustomerService;

/**
 * Servlet implementation class EditAccountServlet
 */
@WebServlet("/EditAccountServlet")
public class EditAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerDAO dao = new CustomerDAOImpl();
		
	     CustomerService service = new CustomerService(dao);
			
	     CustomerController ctrl = new CustomerController(service);
		

	     
	     // Write code to read user's input 
		
		
		String firstname = request.getParameter("firstname");
		
		String lastname = request.getParameter("lastname");
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		String email = request.getParameter("email");
		
		String delivery = request.getParameter("delivery");
		
		
		//get logged in customer
		HttpSession session = request.getSession(true);
		Customer loggedInCustomer = (Customer) session.getAttribute("loggedInCustomer");
		
		
		if (firstname != null && !firstname.equals("")) {
			ctrl.updateFirstName(loggedInCustomer, firstname);
			
			
		}
		
		if (lastname != null && !lastname.equals("")) {
			ctrl.updateLastName(loggedInCustomer, lastname);
			
			
		}
		
		if (username != null && !username.equals("")) {
			ctrl.updateUsername(loggedInCustomer, username);
			
		
		}
		
		if (password != null && !password.equals("")) {
			ctrl.updatePassword(loggedInCustomer, password);
			
			
		}
		if (email != null && !email.equals("")) {
			ctrl.updateEmail(loggedInCustomer, email);
			
			
		}
		if (delivery != null && !delivery.equals("")) {
			ctrl.updateAddress(loggedInCustomer, delivery);
			
		
		}
		
		response.sendRedirect("login.jsp");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
