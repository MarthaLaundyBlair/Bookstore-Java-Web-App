<%@page import="com.ab.models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>

* {box-sizing: border-box}

/* Add padding to containers */
.container {
  padding: 16px;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: LightPink;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit/register button */
.registerbtn {
  background-color: powderblue;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity:1;
}


}


</style>


<meta charset="ISO-8859-1">
<title>Account Details</title>
   <form action="http://localhost:8080/books/EditAccountServlet" method="POST">
   
  <div class="container">
    <h1>Edit Account Details</h1>
    <p>View and Edit your account details below!</p>
    
    <% Customer c = (Customer)session.getAttribute("loggedInCustomer"); %>
    <hr>

    <label for="firstname"><b>First Name: </b></label>
    <input type="text" placeholder=<%= c.getFirstName() %> name="firstname" id="firstname" >
	
	<br>

    <label for="lastname"><b>Last Name: </b></label>
    <input type="text" placeholder=<%= c.getLastName() %> name="lastname" id="lastname" >
    
    <br>
    
    <label for="username"><b>Username: </b></label>
    <input type="text" placeholder=<%= c.getUsername() %> name="username" id="username">
    
    <br>
    
    <label for="password"><b>Password: </b></label>
    <input type="text" placeholder="xxxx" name="password" id="password" >
    
    <br>
    
    <label for="delivery"><b>Delivery Address: </b></label>
    <input type="text" placeholder=<%= c.getDeliveryAdress() %> name="delivery" id="delivery" >
    
    <br>
    
    <label for="email"><b>Email: </b></label>
    <input type="text" placeholder=<%= c.getEmail() %> name="email" id="email">
    
    <hr>


    <button type="submit" class="registerbtn">Submit</button>
  </div>

</form>

</head>
<body>

</body>
</html>