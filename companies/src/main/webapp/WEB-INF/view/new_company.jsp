<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Companies</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="bg-image"
		style="background-image: url('https://rare-gallery.com/thumbs/1073320-white-text-logo-triangle-pattern-Linux-circle-Ubuntu-brand-rectangle-shape-design-floor-line-font-flooring.jpg'); height: 100vh">
		<h1 class="p-3 mb-2 bg-info text-light">Companies</h1>
		<div class="container">
			<hr>
			<h2>Save Company</h2>
			<form action="/saveCompany" method="post">
				<input type="text" id="name" name="name" placeholder="Company Name" class="form-control mb-4 col-4" required> 
				<input type="text" id="website" name="website" placeholder="Website" class="form-control mb-4 col-4" pattern="https?://.+" required>
				<input type="text" id="email" name="email" placeholder=" Email" class="form-control mb-4 col-4" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
				<input type="text" id="address" name="address" placeholder=" Address" class="form-control mb-4 col-4" required> 
				<input type="text" id="tags" name="tags" placeholder=" Tags" class="form-control mb-4 col-4" required>
				<button type="submit" class="btn btn-success col-2">Save Company</button>
			</form>
			<hr>
		</div>
	</div>
</body>
</html>