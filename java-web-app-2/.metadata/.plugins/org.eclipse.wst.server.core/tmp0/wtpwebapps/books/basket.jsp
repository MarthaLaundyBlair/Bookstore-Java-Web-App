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
  background-color: lightpink;
  color: white;
}
</style>

</head>
<body>
    <h1 action="http://localhost:8080/books/LoginServlet" method="POST"> 
   
    <% Customer c = (Customer)session.getAttribute("loggedInCustomer"); %>

     <%= " " + c.getFirstName() + "'s " %> Basket!
    
    </h1>

  <table >
  
  <thread>
  
  	<tr>
  	
  		<th> Title </th>
  		<th> Author </th>
  		<th> IBSN </th>
  		<th> Publisher </th>
  		<th> Publish Date </th>
  		<th> Add to Basket? </th>
  
  	</tr>
  	
  </thread>
  
  	<c:forEach items="${basket}" var="b">
		
		<tr>
		<td> <c:out value="${b.getTitle()}"/> </td>
		<td> <c:out value="${b.getAuthor()}"/> </td>
		<td> <c:out value="${b.getIsbn()}"/> </td>
		<td> <c:out value="${b.getPublisher()}"/> </td>
		<td> <c:out value="${b.getPublish_date()}"/> </td>
		<td>
		
			 <form action="http://localhost:8080/books/BasketRemoveServlet" method="POST">
   
			    <input type = "hidden" name="<%= "bookToRemove" %>" value="${b.getId()}" />
			    <input type="submit" class="registerbtn"  value="Remove!"/>
   
   		</form> 
	
		</td>
		</tr>
	
	</c:forEach>
  
  </table>
  
 Continue <a href="http://localhost:8080/books/LoadAllBooksServlet"> Shopping! </a> <br>

 <h4> Checkout <a href="checkout.jsp"> Here! </a> </h4>
  
</body>
</html>