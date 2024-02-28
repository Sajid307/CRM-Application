<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>trashpage</title>
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
				<h1>Trash</h1>
				<p>Click on the module to delete trash</p>

				<div class="tab">
					<button class="tablinks" onclick="openTab(event, 'Contacts')">Contacts</button>
					<button class="tablinks" onclick="openTab(event, 'Companies')">Companies</button>
					<button class="tablinks" onclick="openTab(event, 'Documents')">Documents</button>
				</div>

				<div id="Contacts" class="tabcontent">
					<table id="myTable1">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Company</th>
							<th>Address</th>
							<th>Tags</th>
							<th>Actions</th>
						</tr>
					
						<tr>
							<c:forEach items="${conData}" var="contacts">
								<tr>
									<td>${contacts.firstName}</td>
									<td>${contacts.lastName}</td>
									<td>${contacts.email}</td>
									<td>${contacts.company}</td>
									<td>${contacts.address}</td>
									<td>${contacts.tags}</td>
									<td>
										<a href="/deleteCon/${contacts.id}" class="btn btn-danger ml-2">Delete</a>
										<a href="/restoreConData/${contacts.id}" class="btn btn-info">Restore</a>
									</td>
								</tr>
							</c:forEach>
						</tr>
					</table>
				</div>

				<div id="Companies" class="tabcontent">
					<table id="myTable2">
						<tr>
							<th>Name</th>
							<th>Website</th>
							<th>Email</th>
							<th>Address</th>
							<th>Tags</th>
							<th>Actions</th>
						</tr>
					
						<tr>
							<c:forEach items="${comData}" var="company">
								<tr>
									<td>${company.name}</td>
									<td>${company.website}</td>
									<td>${company.email}</td>
									<td>${company.address}</td>
									<td>${company.tags}</td>
									<td>
										<a href="/deleteCom/${company.id}" class="btn btn-danger ml-2">Delete</a>
										<a href="/restoreComData/${company.id}" class="btn btn-info">Restore</a>
									</td>
								</tr>
							</c:forEach>
						</tr>
					</table>
				</div>

				<div id="Documents" class="tabcontent">
					<table id="myTable3">
						<tr>
							<th>Name</th>
							<th>Type</th>
							<th>Contacts</th>
							<th>Tags</th>
							<th>Actions</th>
						</tr>
					
						<tr>
							<c:forEach items="${docData}" var="document">
								<tr>
									<td>${document.documentName}</td>
									<td>${document.typeOfDoc}</td>
									<td>${document.contacts}</td>
									<td>${document.tags}</td>
									<td>
										<a href="/deletedoc/${document.id}" class="btn btn-danger ml-2">Delete</a>
										<a href="/restore/${document.id}" class="btn btn-info">Restore</a>
									</td>
								</tr>
							</c:forEach>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>



	<script>

        function openTab(evt, tabName) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tablinks");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(tabName).style.display = "block";
            evt.currentTarget.className += " active";
        }
        
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