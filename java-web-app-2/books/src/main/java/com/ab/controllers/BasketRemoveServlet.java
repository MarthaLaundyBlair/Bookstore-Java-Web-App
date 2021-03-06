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
import com.ab.models.Book;
import com.ab.services.BookService;

/**
 * Servlet implementation class BasketRemoveServlet
 */
@WebServlet("/BasketRemoveServlet")
public class BasketRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketRemoveServlet() {
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
		
		String bookToRemoveString = (String) request.getParameter("bookToRemove");
		int bookToRemoveInt = Integer.parseInt(bookToRemoveString);
		
		Book bookToRemove = ctrl.getBooksByID(bookToRemoveInt);
		
		
		// This below statement enables session
		HttpSession session = request.getSession(true);
	
		
		ArrayList<Book> basket = (ArrayList<Book>) session.getAttribute("basket");
		
		int index = 0;
		for (Book b: basket) {
			if (b.getId() == bookToRemoveInt) {
				break;
			}
				index = index + 1;
			}
		
		basket.remove(index);

		// Redirect the client request
		response.sendRedirect("item_removed.jsp");
	}

}
