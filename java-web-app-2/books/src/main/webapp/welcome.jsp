<%@page import="com.ab.models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!</title>

<style>
body {background-color: white;}
h1   {color: black;}


a {
  color: LightPink;
}

</style>

</head>
<body>
    <h1 action="http://localhost:8080/books/LoginServlet" method="POST"> 
   
    <% Customer c = (Customer)session.getAttribute("loggedInCustomer"); %>

    Hello <%= " " + c.getFirstName() + "!" %>
    
    </h1>

	View Order History  <a href="http://localhost:8080/books/OrdersServlet"> Here! </a> <br>
   
   	Edit Account Details <a href="edit_account.jsp"> Here! </a> <br>
   	
   	Browse Books <a href="http://localhost:8080/books/LoadAllBooksServlet"> Here! </a> <br>
   	
   	View Basket <a href="basket.jsp"> Here! </a>

</body>
</html>