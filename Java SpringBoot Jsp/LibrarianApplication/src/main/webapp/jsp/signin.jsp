<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/signup.css">
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
<title>SignIn</title>
</head>
<body>
<c:set var="userStatus" value="${status}"/>
<div class="container">
		<div class="myCard">
			<div class="row">
				<div class="col-md-6">
					<div class="myLeftCtn">
						<form class="myForm text-center" action="libraraySignIn" onsubmit="return validate()" method="post">
							<header>SignIn to your Account</header>

							<div class="form-group">
								<i class="fas fa-envelope"></i> <input class="myInput"
									placeholder="Email" type="email" id="email" name="email"
									required>
							</div>

							<div class="form-group">
								<i class="fas fa-lock"></i> <input class="myInput"
									type="password" id="password" name="password"
									placeholder="Password" required>
							</div>
							<div>
							<c:if test="${(userStatus eq 'failed') &&(not empty userStatus)}">
                            <h6 style="color: red">*Invalid email and password</h6>
                            </c:if>
							</div>

							<input type="submit" class="butt" value="Sign In">
							<div class="form-group">
							<br>
							<p>Don't have an Account <a id="signup" href="signup">SignUp!</a></p>
								
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