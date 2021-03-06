package com.ab.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import com.ab.daos.BookDAO;
import com.ab.daos.BookDAOImpl;
import com.ab.models.Book;
import com.ab.services.BookService;

/**
 * Servlet implementation class BasketServlet
 */
@WebServlet("/BasketServlet")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketServlet() {
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
		BookDAO dao = new BookDAOImpl();
		
        BookService service = new BookService(dao);
		
		BookController ctrl = new BookController(service);
		
		String bookToAddString = (String) request.getParameter("bookToAdd");
		int bookToAddInt = Integer.parseInt(bookToAddString);
		
		Book bookToAdd = ctrl.getBooksByID(bookToAddInt);
		
		
		// This below statement enables session
		HttpSession session = request.getSession(true);
	
		
		ArrayList<Book> basket = (ArrayList<Book>) session.getAttribute("basket");
		basket.add(bookToAdd);

		// Redirect the client request
		response.sendRedirect("basket.jsp");
	}

}
