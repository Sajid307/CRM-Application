<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Tag Manager</title>
<link rel="stylesheet" href="tagstyle2.css">
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

form {
	margin-bottom: 20px;
}

input[type="text"] {
	padding: 5px;
	font-size: 16px;
}

button {
	padding: 10px 15px;
	font-size: 16px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 10px;
	cursor: pointer;
	margin-left: 10px;
	box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.5);
}

button:hover {
	background-color: #3e8e41;
}

ul {
	list-style: none;
	padding: 0;
	margin: 0;
}

.update-tag, .delete-tag {
	padding: 5px 10px;
	font-size: 12px;
	background-color: #008CBA;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-left: 10px;
}

.update-tag:hover, .delete-tag:hover {
	background-color: #006080;
}

body {
	padding-top: 70px;
}

body, html {
	height: 100%;
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

/* Position text in the middle of the page/image */
.bg-text {
	color: black;
	font-weight: bold;
	border: 3px solid #f1f1f1;
	position: absolute;
	top: 58%;
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
				</ul>
			</div>
			<div></div>
			<div class="right" style="background-color: #ddd;">
				<div class="container">
					<hr>
					<h2>Add Tag</h2>
					<form action="/addTag" method="post">
						<input type="int" id="id" name="id" placeholder="Tag id" class="form-control mb-4 col-4" required> 
						<input type="text" id="tag" name="tag" placeholder="Tag Name" class="form-control mb-4 col-4" required>
						<button type="submit" class="btn btn-success col-2">Save
							Tag</button>
					</form>
					<hr>
				</div>
			</div>
		</div>
	</div>

	<script>
		/**
		 * 
		 */
		const createTagForm = document.getElementById('create-tag-form');
		const newTagNameInput = document.getElementById('new-tag-name');
		const tagList = document.getElementById('tag-list');

		// Add event listener to create tag form
		createTagForm
				.addEventListener(
						'submit',
						function(event) {
							event.preventDefault();
							const newTagName = newTagNameInput.value;
							if (newTagName === '') {
								alert('Please enter a tag name.');
								return;
							}
							const newTagElement = document.createElement('li');
							newTagElement.innerHTML = `${newTagName} <button class="update-tag">Update</button> <button class="delete-tag">Delete</button>`;
							tagList.appendChild(newTagElement);
							newTagNameInput.value = '';
						});

		// Add event listeners to tag list for updating and deleting tags
		tagList.addEventListener('click', function(event) {
			const target = event.target;
			if (target.classList.contains('update-tag')) {
				const currentTagName = target.parentNode.textContent.trim();
				const newTagName = prompt('Enter a new name for the tag:',
						currentTagName);
				if (newTagName === null || newTagName.trim() === '') {
					return;
				}
				target.parentNode.firstChild.textContent = newTagName;
			} else if (target.classList.contains('delete-tag')) {
				if (confirm('Are you sure you want to delete this tag?')) {
					target.parentNode.remove();
				}
			}
		});

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