<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

* {
  box-sizing: border-box;
}

form.example input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

form.example button {
  float: left;
  width: 20%;
  padding: 10px;
  background: powderblue;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: LightPink;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}

a {
  color: LightPink;
}
</style>

<title> Search by Author </title>

</head>
<body>

<h2>Search Books!</h2>


<p>Search all our books by their author:</p>
<form class="example" action="http://localhost:8080/books/BooksByAuthorServlet" method="POST" >
  <input type="text" placeholder="Search.." name="author">
  <button type="submit"><i class="fa fa-search"></i></button>
</form>
  <a href="search_title.jsp"> Search by title instead? </a> &nbsp;&nbsp;&nbsp;
</body>
</html> 
