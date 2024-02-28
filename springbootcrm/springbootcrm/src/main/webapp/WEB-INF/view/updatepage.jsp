<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doc Management System</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>Edit Document Page</h1>
		<hr>
		<h3>Update Document Name</h3>
		<form action="/saveDocument" object="document" method="post">
					<input type="int" id="id" name="id" value="${id}" style="display:none" >
		
			<input type="text" id="documentName" name="documentName"
				placeholder="DocumentName" class="form-control mb-4 col-4" required>
			<button type="submit" class="btn btn-info col-2">Update Name</button>
		</form>
		<hr>
		<a href="/showHomepage"> Back to Document List</a>
	</div>
</body>