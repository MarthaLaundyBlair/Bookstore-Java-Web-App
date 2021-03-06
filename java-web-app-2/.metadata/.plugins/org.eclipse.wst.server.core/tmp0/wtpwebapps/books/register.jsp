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

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}


</style>


<meta charset="ISO-8859-1">
<title> Register Page </title>
</head>
<body>


   <h1> Registration Form </h1>
   
    <form action="http://localhost:8080/books/RegisterServlet" method="POST">
   
  <div class="container">
    <p>Fill in your details below to make an account!</p>
    <hr>

    <label for="firstname"><b>First Name: </b></label>
    <input type="text" placeholder="Enter first name" name="firstname" id="firstname" required>
	
	<br>

    <label for="lastname"><b>Last Name: </b></label>
    <input type="text" placeholder="Enter last name" name="lastname" id="lastname" required>
    
    <br>
    
    <label for="username"><b>Username: </b></label>
    <input type="text" placeholder="Enter username" name="username" id="username" required>
    
    <br>
    
    <label for="password"><b>Password: </b></label>
    <input type="password" placeholder="Enter password" name="password" id="password" required>
    
    <br>
    
    <label for="delivery"><b>Delivery Address: </b></label>
    <input type="text" placeholder="Enter delivery address" name="delivery" id="delivery" required>
    
    <br>
    
    <label for="email"><b>Email: </b></label>
    <input type="text" placeholder="Enter email address" name="email" id="email" required>
    
    <hr>


    <button type="submit" class="registerbtn">Register</button>
  </div>

</form>



	

</body>
</html>