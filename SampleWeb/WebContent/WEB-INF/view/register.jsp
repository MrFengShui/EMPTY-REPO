<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="WEB-RES/css/dark-style.css"/>
<title>Register Page</title>
</head>
<body id="register-body">
<header id="register-page-header">My First JSP Web Project</header>
<div id="register-section">
	<div style="display: inline-flex;width: 100%;">
		<header id="register-section-header">Sign Up</header>
		<a href="login" id="register-header-link">Login</a>
	</div>
	<form:form method="POST" commandName="registerBean" cssClass="register-form-style">
		<table id="register-form-table">
			<tr>
				<td><form:label path="firstname">FIRSTNAME</form:label></td>
				<td><form:input path="firstname"/></td>
			</tr>
			<tr>
				<td><form:label path="lastname">LASTNAME</form:label></td>
				<td><form:input path="lastname"/></td>
			</tr>
			<tr>
				<td><form:label path="dateOfBirth">Date of Birth</form:label></td>
				<td><form:input type="date" path="dateOfBirth"/></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input type="email" path="email"/></td>
			</tr>
			<tr>
				<td><form:label path="gender">Gender</form:label></td>
				<td id="register-gender-row"><form:radiobuttons path="gender" items="${genders}" style="width: 50px;"/></td>
			</tr>
			<tr>
				<td><form:label path="nation">Nationality</form:label></td>
				<td>
					<form:select path="nation">
						<form:option value="None">----- Select -----</form:option>
						<form:options items="${nations}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="username">USERNAME</form:label></td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td><form:label path="password">PASSWORD</form:label></td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td><form:label path="confirmPassword">CONFIRM PASSWORD</form:label></td>
				<td><form:password path="confirmPassword"/></td>
			</tr>
			<tr>
				<td colspan="2"><textarea readonly>${contract}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><form:label path="agree"><form:checkbox path="agree" value="true" style="width: 50px;"/>I have read and agreed this agreement.</form:label></td>
			</tr>
			<tr>
				<td colspan="2"><form:button>REGISTER</form:button></td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>