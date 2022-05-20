<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@page import="com.ab.models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Basket</title>

<style>

a {
  color: LightPink;
}

th, td {
  padding: 15px;
  text-align: left;
}

th {
  background-color: powderblue;
  color: white;
}

.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid lightpink;
  font-size: 20px;
}

</style>

</head>
<body>
	<h1>Checkout Below!</h1>

    <h3 action="http://localhost:8080/books/LoginServlet" method="POST"> 
   
    <% Customer c = (Customer)session.getAttribute("loggedInCustomer"); %>

     <%= " " + c.getFirstName() + "'s " %> Order
    
    </h3>
    
    <h4> Please review your order details below:</h4>

  <table >
  
  <thread>
  
  	<tr>
  	
  		<th> Title </th>
  		<th> Author </th>
  		<th> IBSN </th>
  		<th> Publisher </th>
  		<th> Publish Date </th>
  
  	</tr>
  	
  </thread>
  
  	<c:forEach items="${basket}" var="b">
		
		<tr>
		<td> <c:out value="${b.getTitle()}"/> </td>
		<td> <c:out value="${b.getAuthor()}"/> </td>
		<td> <c:out value="${b.getIsbn()}"/> </td>
		<td> <c:out value="${b.getPublisher()}"/> </td>
		<td> <c:out value="${b.getPublish_date()}"/> </td>
		
	
		</td>
		</tr>
	
	</c:forEach>
	
	<%= "Delivery adress:" + c.getDeliveryAdress() %>
  
  </table>
  
 Back to <a href="basket.jsp"> Basket! </a> <br>
 <br>
 
	 <form action="http://localhost:8080/books/CheckoutServlet" method="POST">
	   
	
				    <input type="submit" class="button1"  value="Submit Order!"/>
	   
	 </form> 
 
  
</body>
</html>