package com.ab.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.daos.BookDAO;
import com.ab.daos.BookDAOImpl;
import com.ab.models.Book;
import com.ab.services.BookService;

/**
 * Servlet implementation class BooksByTitleServlet
 */
@WebServlet("/BooksByTitleServlet")
public class BooksByTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksByTitleServlet() {
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
		
		String title = request.getParameter("title");
		
		List<Book> books = ctrl.getBooksByTitle(title);
		String booksString = ctrl.getBooksByTitleString(title);
	
		
		// This below statement enables session
		HttpSession session = request.getSession(true);
		
		// Code to store list of students in a session object

		session.setAttribute("booksByTitleList", books);
		session.setAttribute("booksByTitleString", booksString);
		
		// Redirect the client request
		response.sendRedirect("display_by_title.jsp");
	}

}
