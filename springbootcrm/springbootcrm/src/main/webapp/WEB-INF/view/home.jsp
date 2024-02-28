<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>DocumentHome</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Including the bootstrap CDN -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: Arial;
}

/* Style the tab */
.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}

h1 {
	background-color: rgb(74, 141, 74);
	color: #FFF;
	padding: 5px;
	width: 90%;
	margin: 20px auto;
	box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.5);
	border-radius: 10px;
	overflow-x: auto;
}

table {
	border-collapse: collapse;
	margin: 0 auto;
}

th, td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #CCC;
}

th {
	background-color: rgb(103, 101, 112);
	color: #FFF;
}

.btnD {
	border: none;
	color: white;
	padding: 14px 28px;
	font-size: 16px;
	cursor: pointer;
}

.delete {
	background-color: #f44336;
}

/* Red */
.delete:hover {
	background: #da190b;
}

/* Position text in the middle of the page/image */
.bg-text {
	color: black;
	font-weight: bold;
	border: 3px solid #f1f1f1;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	z-index: 2;
	width: 80%;
	padding: 20px;
	text-align: center;
}

.container {
	position: relative;
	margin: 0 auto;
}

.lis {
	text-align: left;
}

.row {
	display: flex;
}

/* Left column (menu) */
.left {
	flex: 35%;
	padding: 15px 0;
}

.left h2 {
	padding-left: 8px;
}

/* Right column (page content) */
.right {
	flex: 65%;
	padding: 15px;
}

/* Style the search box */
#mySearch {
	width: 100%;
	font-size: 18px;
	padding: 11px;
	border: 1px solid #ddd;
}

/* Style the navigation menu inside the left column */
#myMenu {
	list-style-type: none;
	padding: 0;
	margin: 0;
}

#myMenu li a {
	padding: 12px;
	text-decoration: none;
	color: black;
	display: block
}

#myMenu li a:hover {
	background-color: #eee;
}

.search {
	margin: 10px 0;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}
/* Style the table */
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #4CAF50;
	color: white;
}
/* Style the buttons */
.add, td a {
	display: inline-block;
	padding: 8px 16px;
	margin: 10px 0;
	border-radius: 4px;
	text-decoration: none;
	background-color: #4CAF50;
	color: white;
}

.edit, .delete {
	display: inline-block;
	padding: 8px 16px;
	margin: 10px 0;
	border-radius: 4px;
	text-decoration: none;
	background-color: #4CAF50;
	color: white;
}

.add:hover, td a:hover {
	background-color: #3e8e41;
}

.edit:hover {
	background-color: #3e8e41;
}

.delete:hover {
	background-color: #3e8e41;
}

.add:active, .edit:active, .delete:active {
	background-color: #3e8e41;
	transform: translateY(1px);
}
</style>
</head>

<body>

	<div class="container">
		<nav class="navbar fixed-top navbar-expand-sm bg-info navbar-light">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand "
						style="color: rgb(247, 248, 251); font-weight: bold;" href="#">CRM_Application_CTS</a>
				</div>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link "
						style="font-size: 20px" href="main.html"><b>Home</b></a></li>
				</ul>
			</div>
		</nav>
	</div>

	<div class="bg-text">
		<div class="row">
			<div class="left" style="background-color: #bbb;">
				<input type="text" id="mySearch" onkeyup="myFunction()"
					placeholder="Search.." title="Type in a category">
				<ul id="myMenu">
					<li><a href="test_contacts.html">CONTACTS</a></li>
					<li><a href="test_companies.html">COMPANIES</a></li>
					<li><a href="test_document.html">DOCUMENTS</a></li>
					<li><a href="mailbox.html">INBOX</a></li>
					<li><a href="test_reports.html">REPORTS</a></li>
					<li><a href="optionSettings.html">SETTINGS</a></li>
					<li><a href="tagIndex.html">TAGS</a></li>
					<li><a href="access.html">ADMIN TOOLS</a></li>
					<li><a href="trashhomepage.html">TRASH</a></li>
			</div>

			<div></div>

			<div class="right" style="background-color: #ddd;">
				<h1>Document List</h1>
				<div class="search">
					<input type="text" id="search" onkeyup="searchTable()"
						placeholder="Search...">
				</div>
				<table id="documents">
					<thead>
						<tr>
							<th>Name</th>
							<th>Type</th>
							<th>Contacts</th>
							<th>Tag</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach items="${data}" var="i">
								<tr>
									<td>${i.documentName}</td>
									<td>${i.typeOfDoc}</td>
									<td>${i.contacts}</td>
									<td>${i.tags}</td>
									<td><a href="/updatepage/${i.id}" class="btn btn-info">Update</a>
										<a href="/changeTrash/${i.id}" class="btn btn-danger ml-2">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tr>
					</tbody>
				</table>
				<div class="add">
					<a href="/showdeleteForm">Add Document</a>
				</div>
			</div>
		</div>
	</div>



	<script>
		function myFunction() {
			var input, filter, ul, li, a, i;
			input = document.getElementById("mySearch");
			filter = input.value.toUpperCase();
			ul = document.getElementById("myMenu");
			li = ul.getElementsByTagName("li");
			for (i = 0; i < li.length; i++) {
				a = li[i].getElementsByTagName("a")[0];
				if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
					li[i].style.display = "";
				} else {
					li[i].style.display = "none";
				}
			}
		}
	</script>

</body>

</html>