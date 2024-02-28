<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Contact</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Contacts Names</h1>
		<hr>

		<h1>Update Contact</h1>

<form method="post" action="/updateContact/${contact.id}">
    <input type="hidden" name="_method" value="post">
    <input type="hidden" name="id" value="${contact.id}">

    <label for="company">Company:</label>
    <input type="text" id="company" name="company" value="${contact.company}" required><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" value="${contact.address}" required><br>

    <label for="tags">Tags:</label>
    <input type="text" id="tags" name="tags" value="${contact.tags}" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${contact.email}" required><br>

    <button type="submit">Update Contact</button>
</form>







		<!--	<h2>Save Contact</h2>
	  	<form action="/updateContact/{id}" method="post">
			<input type="text" id="company" name="company" placeholder="Company" class="form-control mb-4 col-4"> 
			<input type="text" id="email" name="email" placeholder="Email" class="form-control mb-4 col-4"> 
			<input type="text" id="address" name="address" placeholder="Address" class="form-control mb-4 col-4">
			<input type="text" id="tags" name="tags" placeholder="Tags" class="form-control mb-4 col-4">
			<button type="submit" class="btn btn-info col-2">Save Contact</button>
		</form> -->
		<hr>
	</div>
</body>
</html>