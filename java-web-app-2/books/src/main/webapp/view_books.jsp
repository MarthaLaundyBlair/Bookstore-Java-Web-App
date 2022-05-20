<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page import="com.ab.models.Book"%>
<%@page import="java.util.List"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.ObjectOutputStream"%>
<%@page import="java.util.Base64"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Books</title>

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


 
 <h1> List of Books : </h1>
 
  <a href="search_books.jsp"> Search books? </a> &nbsp;&nbsp;&nbsp;
  
  <br>
  <br>
  
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
  
  	<c:forEach items="${booksList}" var="b">
		
		<tr>
		<td> <c:out value="${b.getTitle()}"/> </td>
		<td> <c:out value="${b.getAuthor()}"/> </td>
		<td> <c:out value="${b.getIsbn()}"/> </td>
		<td> <c:out value="${b.getPublisher()}"/> </td>
		<td> <c:out value="${b.getPublish_date()}"/> </td>
		<td>
		
			 <form action="http://localhost:8080/books/BasketServlet" method="POST">
   
			    <input type = "hidden" name="<%= "bookToAdd" %>" value="${b.getId()}" />
			    <input type="submit" class="registerbtn"  value="Add to basket!"/>
   
   		</form> 
	
		</td>
		</tr>
	
	</c:forEach>
  
  </table>
  
  
	
	

	

</body>

</html>