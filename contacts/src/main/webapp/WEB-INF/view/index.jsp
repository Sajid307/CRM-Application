<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONTACTS LIST</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<div class="container my-2">
		<h1>Contacts List</h1>
		<a href="/addContactForm" class="btn btn-primary btn-sm mb-3">Add Contact </a>
		<button class='btn btn-primary float-right'>HOME</button>
		<table border="1" class="table table-striped table-responsive-md">
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Company</th>
				<th>Email</th>
				<th>Address</th>
				<th>Tags</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${data}" var="contactDetails">
				<tr>
					<td>${contactDetails.firstName}</td>
					<td>${contactDetails.lastName}</td>
					<td>${contactDetails.company}</td>
					<td>${contactDetails.email}</td>
					<td>${contactDetails.address}</td>
					<td>${contactDetails.tags}</td>
					<td>
						<a href="/updateContactForm/${contactDetails.id}" class="btn btn-info">Update</a>
						<a href="/changeTrash/${contactDetails.id}" class="btn btn-danger ml-2">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>