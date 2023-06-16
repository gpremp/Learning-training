<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page errorPage="error" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="date" value="<%=new java.util.Date()%>" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/addbook.css">
<script type="text/javascript" src="/js/addBook.js"></script>
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
<title>Add a Book</title>
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
    <c:set var="bookStatus" value="${bookStatus}"/>
    <c:if test="${(bookStatus eq 'success') &&(not empty bookStatus)}">
    <input type="hidden" id="bookAddStatus" value="success">
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
						<h5 class="card-header">Add Book Details</h5>
						<div class="card-body">
							<form action="addNewBook" onsubmit="return validate()" method="post">
								<table class="table">
									<thead>
										<tr class="tre">
											<th>Book Code</th>
											<th><input placeholder="Book code" type="number"
												name="bookCode" required>
												<br>
												<c:if test="${(bookStatus eq 'failed') &&(not empty bookStatus)}">
                                                <h6 class="formerror">*Book code already present</h6>
                                                </c:if>
												</th>
										</tr>
										<tr>
											<th>Book Name</th>
											<th><input placeholder="Book Name" type="text"
												name="bookName" id="bookName" required>
												<h6 id="bookError" class="formerror"> </h6>
												</th>
										</tr>
										<tr>
											<th>Author</th>
											<th><select name="getAuthor">
											<c:forEach var="authors" items="${authors}">
											<option value="${authors.firstName} ${authors.lastName}">${authors.firstName} ${authors.lastName}</option>
											</c:forEach>
											</select></th>
										</tr>
										<tr>
											<th>Date Added</th>
											<th><fmt:formatDate type="date" value="${date}" /></th>
										</tr>

									</thead>
								</table>
								<input type="submit" class="btn btn-success active addBtn"
									value="Submit"> <a href="librarybooks"
									class="btn btn-danger active" role="button" aria-pressed="true">Back</a>
							</form>
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