<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COMPANIES LIST</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="bg-image">
		<h1 class="p-3 mb-2 bg-info text-light">Companies List</h1>
		<div class="container my-2">
			<div>
				<a href="/companiesForm" class="btn btn-success   mb-3">Add
					Company</a>
				<div class="float-right">
					<!--  <form action="/">
						<input class="textbox-10" placeholder="Filter here..." type="text" name="keyword" id="keyword" size="50" value="${keyword}" required /> -->
					<div class="search-bar">
						<input type="text" id="search-input"
							placeholder="Search by name..." oninput="filterTable()">
					</div>
					<style>
.textbox-10 {
	border: 3px outset #32CD32;
	outline: 0;
	height: 35px;
	width: 275px;
}

input::placeholder {
	font-weight: bold;
	opacity: 0.7;
	color: DarkSlateGrey;
}
</style>
					&nbsp; <input type="submit" value="Search" class="btn btn-success" />
					&nbsp; <input type="button" value="Clear" id="btnClear"
						onclick="clearSearch()" class="btn btn-success" />
					</form>
				</div>

				<table border="1" class="table table-striped table-responsive-md">
					<tr>
						<th>Name</th>
						<th>Website</th>
						<th>Email</th>
						<th>Address</th>
						<th>Tags</th>
						<th>Actions</th>
					</tr>

					<tr>
						<c:forEach items="${data}" var="Company">
							<tr>
								<td>${Company.name}</td>
								<td>${Company.website}</td>
								<td>${Company.email}</td>
								<td>${Company.address}</td>
								<td>${Company.tags}</td>
								<td><a href="/showFormForUpdate/${Company.id}" class="btn btn-warning">Update</a> 
									<a href="/changeTrash/${Company.id}" class="btn btn-dark text-light ml-2">Delete</a></td>
							</tr>
						</c:forEach>
				</table>
			</div>

			<script type="text/javascript">
				
			<%--	function clearSearch() {
					window.location = "[[@{/}]]";
				}--%>
				function filterTable() {
					var input = Company.getElementById("search-input");
					var filter = input.value.toLowerCase();
					var table = Company.getElementById("data-table");
					var rows = table.getElementsByTagName("tr");

					for (var i = 0; i < rows.length; i++) {
						var nameCell = rows[i].getElementsByTagName("td")[0];

						if (nameCell) {
							var name = nameCell.innerHTML.toLowerCase();
							if (name.includes(filter)) {
								rows[i].style.display = "";
							} else {
								rows[i].style.display = "none";
							}
						}
					}
				}
			</script>
</body>
</html>