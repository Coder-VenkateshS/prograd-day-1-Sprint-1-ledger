<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
Welcome to Registration
<form action="/WebApplication/RegisterServlet" method="post">
<label> First name:</label><br><input type="text" name="firstname" required><br>
<label> Last name:</label><br><input type="text" name="lastname" required><br>
<label> User name:</label><br><input type="text" name="username" required><br>
<label> Password:</label><br><input type="password" name="password" required><br>
<label> Confirm Password:</label><br><input type="password" name="confirmpassword" required><br>
<label> Email:</label><br><input type="email" name="email" required><br>
<label> Mobile:</label><br><input type="number" name="mobile" required><br>
<input type="submit" name="signup" value="Signup">
</form>
</body>
</html>