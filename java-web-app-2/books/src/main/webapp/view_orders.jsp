<%@page import="com.ab.models.Customer"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page import="com.ab.models.Book"%>
<%@page import="com.ab.models.Order"%>
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
<title>Orders</title>



</head>
<body>

	<%
	Customer c = (Customer) session.getAttribute("loggedInCustomer");
	%>

	<h1>
		<%=c.getFirstName() + "'s Orders!"%>
	</h1>

  
  	<c:forEach items="${customerOrders}" var="c">
		
		<h3> Order number ${c.getOrder_num()} </h3>
		
		
		${c.orderBooksString()}
		
		<br>
		
	</c:forEach>

  



		

</body>
</html>