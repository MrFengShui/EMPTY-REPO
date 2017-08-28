<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="WEB-RES/css/dark-style.css" />
<title>Login Page</title>
</head>
<body>
	<div class="page-header">
		<header>SAMPLE WEB - LOGIN PAGE</header>
	</div>
	<div class="page-center" style="height: 75%;">
		<section class="form-section"
			style="max-width: 640px; max-height: 480px;">
			<header class="section-header">SIGN IN</header>
			<form:form method="POST" commandName="indexBean"
				cssClass="section-form">
				<div class="table-row">
					<div class="table-cell">
						<form:label path="username">USERNAME</form:label>
					</div>
					<div class="table-cell">
						<form:input path="username" style="width: 450px;" />
					</div>
				</div>
				<div class="table-row">
					<div class="table-cell">
						<form:label path="password">PASSWORD</form:label>
					</div>
					<div class="table-cell">
						<form:password path="password" style="width: 450px;" />
					</div>
				</div>
				<div class="table-foot"><form:button>LOGIN</form:button></div>
			</form:form>
			<div id="login-section-link">
				<a href="register">Register</a> <a href="#">Question</a> <a
					href="about">About</a>
			</div>
		</section>
	</div>
</body>
</html>