<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>company module</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<div class="bg-image"
		style="background-image: url('https://rare-gallery.com/thumbs/1073320-white-text-logo-triangle-pattern-Linux-circle-Ubuntu-brand-rectangle-shape-design-floor-line-font-flooring.jpg'); height: 100vh">
		<h1 class="p-3 mb-2 bg-info text-light">
			Companies
			<div class="float-right">
				<a href="#" class="btn btn-warning btn-sm mb-3"> Back to
					Companies List</a>
			</div>
		</h1>
		<div class="container">
			<hr>
			<!-- <h2>Update Company</h2>
			<form action="/updateCompany/{company.id}" method="put"> 
			     <input type="hidden" id="id" name="id"/>
				<input type="text" id="website" name="website" placeholder="Website" class="form-control mb-4 col-4" pattern="https?://.+" required>
				<input type="text" id="email" name="email" placeholder=" Email" class="form-control mb-4 col-4" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
				<input type="text" id="address" name="address" placeholder=" Address" class="form-control mb-4 col-4" required> 
				<input type="text" id="tags" name="tags" placeholder=" Tags" class="form-control mb-4 col-4" required>
				<button type="submit" class="btn btn-success col-2">Save Company</button>
			</form> -->

			<h1>Update Contact</h1>

			 

			<form method="post" action="/updateCompany/${company.id}">
				<input type="hidden" name="_method" value="post"> 
				<input type="hidden" name="id" value="${company.id}">       
			 	<input type="text" id="website" name="website" placeholder="Website" value="${company.website}" class="form-control mb-4 col-4" pattern="https?://.+" required>
			 	<input type="email" id="email" name="email" placeholder=" Email" value="${company.email}" class="form-control mb-4 col-4" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>  
				<input type="text" id="address" name="address" placeholder=" Address" value="${company.address}" class="form-control mb-4 col-4" required>
				<input type="text" id="tags" name="tags" placeholder=" Tags" value="${company.tags}" class="form-control mb-4 col-4" required>  
				<button type="submit"  class="btn btn-success col-2">Update Contact</button>
			</form>
			<hr>
		</div>
	</div>
</body>
</html>
