<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page errorPage="error" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/library.css">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript" src="/js/libraraybook.js"></script>
<title>Library</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
<c:if test="${empty user}">
    <c:redirect url = "logout"/>
    </c:if>
<nav id="navbar" class="navbar">
  <h4>Library Management</h4>
  <div class="float-right">
  <form action="logoutUser">
  <table>
  <tr>
    <th><h5 class="nav-item">Welcome <c:out value="${user}"></c:out></h5></th>
    <th><button type="submit" class="btn btn-success active">Log out</button>
  </tr>
  </table>
  </form>
  </div>
</nav>

<div class="container">
		<div class="myCard">
			<div class="row">
				<div class="col-md-12">
					<div class="card text-center">
						<table>
							<tr>
								<th><h5 class="card-header">Book Listing</h5></th>
								<th><a href="addbook" class="btn btn-success active addBtn"
									role="button" aria-pressed="true">Add a Book</a></th>
							</tr>
						</table>
						 <div class="card-body">
						 <table class="table">
			<thead>
				<tr class="tableHead">
					<th class="bookRow">Book Code</th>
					<th class="bookRow">Book Name</th>
					<th class="bookRow">Author</th>
					<th class="bookRow">Date Added</th>
					<th class="bookRow">Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="book" items="${books}">
			<tr>
			    <th class="bookRow">${book.id}</th>
					<th class="bookRow">${book.bookName}</th>
					<th class="bookRow">${book.authorName}</th>
					<th class="bookRow">${book.bookDate}</th>
					<th class="bookRow">
					<form action="editbook">
					<input type="hidden" name="bookId" value="${book.id}">
					<input type="hidden" name="user" value="${user}">
					<input type="submit" class="btn btn-success active addBtn" value="Edit">
					<button type="button" class="btn btn-danger active" value="${book.id}" onclick="deleteBook(this.value)">Delete</button>
					</form> </th>
					
			</tr>
			</c:forEach>
			</tbody>
			</table>

						 </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
	  <nav id="footer" class="fixed-bottom">
  <h5 class="text-center">Spring Boot Training</h5>
    </nav>
	</footer>
</body>
</html>