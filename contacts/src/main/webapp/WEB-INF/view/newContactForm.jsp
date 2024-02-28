<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts Listed</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Contacts Names</h1>
		<hr>
		<h2>Save Contact</h2>
		<form action="/addContact" method="post">
			<input type="text" id="firstName" name="firstName" placeholder="Contact FirstName" class="form-control mb-4 col-4"> 
			<input type="text" id="lastName" name="lastName" placeholder="Contact LastName" class="form-control mb-4 col-4">
			<input type="text" id="company" name="company" placeholder="Company" class="form-control mb-4 col-4"> 
			<input type="text" id="email" name="email" placeholder="Email" class="form-control mb-4 col-4"> 
			<input type="text" id="address" name="address" placeholder=" Address" class="form-control mb-4 col-4">
			<input type="text" id="tags" name="tags" placeholder=" Tags" class="form-control mb-4 col-4">
			<button type="submit" class="btn btn-info col-2">Save Contact</button>
		</form>
		<hr>
	</div>
</body>
</html>