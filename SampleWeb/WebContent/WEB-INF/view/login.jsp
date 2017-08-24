<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="WEB-RES/css/dark-style.css"/>
<title>Login Page</title>
</head>
<body id="login-body">
<header id="login-page-header">My First JSP Web Project</header>
<div id="login-section">
	<header id="login-section-header">Sign In</header>
	<form:form method="POST" commandName="indexBean" cssClass="login-form-style">
		<table id="login-form-table">
			<tr>
				<td><form:label path="username">USERNAME</form:label></td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td><form:label path="password">PASSWORD</form:label></td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><form:button>LOGIN</form:button></td>
			</tr>
		</table>
	</form:form>
	<div id="login-section-link">
		<a href="register">Register</a>
		<a href="#">Question</a>
		<a href="about">About</a>
	</div>
</div>
</body>
</html>