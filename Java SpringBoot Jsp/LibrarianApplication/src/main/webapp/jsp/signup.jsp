<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/signup.css">
<script type="text/javascript" src="/js/signup.js"></script>
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
	<!-- Sweet Alert library link -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>SignUp</title>
</head>
<body>
    <!-- Checking for user signup failed or success -->
    <c:set var="userStatus" value="${status}"/>
    <c:if test="${(userStatus eq 'success') &&(not empty userStatus)}">
    <input type="hidden" id="statuss" value="success">
    </c:if>
     <c:if test="${(userStatus eq 'failed') &&(not empty userStatus)}">
    <input type="hidden" id="statuss" value="failed">
    </c:if>
    <!-- Container class for sigup-->
	<div class="container">
		<div class="myCard">
			<div class="row">
				<div class="col-md-6">
					<div class="myLeftCtn">
						<form class="myForm text-center" action="register" onsubmit="return validate()" method="post">
							<header>Create new account</header>
							<div class="form-group" id="first_Name">
								<i class="fas fa-user"></i> <input class="myInput" type="text"
									placeholder="First Name" id="fname" name="FirstName" required>
									<h6 class="formerror"> </h6>
							</div>

							<div class="form-group" id="last_name">
								<i class="fas fa-user"></i> <input class="myInput" type="text"
									placeholder="Last Name" id="lname" name="LastName" required>
									<h6 class="formerror"> </h6>
							</div>

							<div class="form-group" id="inputemail">
								<i class="fas fa-envelope"></i> <input class="myInput"
									placeholder="Email" type="email" id="email" name="email" required>
									<h6 class="formerror"> </h6>
							</div>

							<div class="form-group" id="inputPassword">
								<i class="fas fa-lock"></i> <input class="myInput"
									type="password" id="password" name="password"
									placeholder="Password" required>
									<h6 class="formerror"> </h6>
							</div>

							<div class="form-group" id="inputRepeatpwd">
								<i class="fas fa-lock"></i> <input class="myInput"
									type="password" id="repeatPassword"
									placeholder="Repeat Password" required>
									<h6 class="formerror"> </h6>
							</div>

							<input type="submit" class="butt" value="CREATE ACCOUNT">
							<div class="form-group">
								<p>Already have an Account <a href="signin">SignIn!</a></p>
							</div>

						</form>

					</div>
				</div>
				<div class="col-md-6">
					<div class="myRightCtn">
						<div class="box">
							<header>Welcome User!</header>
							<img src="/resources/libraray.jpg" width="300" height="200">
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>