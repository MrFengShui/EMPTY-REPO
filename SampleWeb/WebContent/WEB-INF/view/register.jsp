<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="WEB-RES/css/dark-style.css" />
<title>Register Page</title>
</head>
<body>
	<div class="page-header">
		<header>SAMPLE WEB - REGISTER PAGE</header>
	</div>
	<div class="page-center">
		<div class="form-section" style="max-width: 800px;">
			<div style="display: inline-flex; width: 100%;">
				<header class="section-header">SIGN UP</header>
				<a href="login" id="register-header-link"
					style="width: 10%; height: 50px;">Login</a>
			</div>
			<form:form method="POST" commandName="registerBean" cssClass="section-form">
				<div class="table-row">
					<div class="table-cell"><form:label path="firstname">FIRSTNAME</form:label></div>
					<div class="table-cell"><form:input path="firstname" style="width: 500px;"/></td></div>
				</div>
				<div class="table-row">
					<div class="table-cell"><form:label path="lastname">LASTNAME</form:label></div>
					<div class="table-cell"><form:input path="lastname" style="width: 500px;"/></div>
				</div>
				<div class="table-row">
					<div class="table-cell"><form:label path="dateOfBirth">DATE OF BIRTH</form:label></div>
					<div class="table-cell"><form:input type="date" path="dateOfBirth" style="width: 500px;"/></div>
				</div>
				<div class="table-row">
					<div class="table-cell"><form:label path="email">EMAIL</form:label></div>
					<div class="table-cell"><form:input type="email" path="email" style="width: 500px;"/></div>
				</div>
				<div class="table-row">
					<div class="table-cell" style="height: 50px;"><form:label path="gender">GENDER</form:label></div>
					<div class="table-cell" style="display: flex;"><form:radiobuttons path="gender" items="${genders}"/></div>
				</div>
				<div class="table-row">
					<div class="table-cell"><form:label path="nation">NATIONALITY</form:label></div>
					<div class="table-cell">
						<form:select path="nation">
							<form:option value="None" style="width: 500px;">----- Select -----</form:option>
							<form:options items="${nations}" />
						</form:select>
					</div>
				</div>
				<div class="table-row">
					<div class="table-cell"><form:label path="username">USERNAME</form:label></div>
					<div class="table-cell"><form:input path="username" style="width: 500px;"/></div>
				</div>
				<div class="table-row">
					<div class="table-cell"><form:label path="password">PASSWORD</form:label></div>
					<div class="table-cell"><form:password path="password" style="width: 500px;"/></div>
				</div>
				<div class="table-row">
					<div class="table-cell"><form:label path="confirmPassword">CONFIRM PASSWORD</form:label></div>
					<div class="table-cell"><form:password path="confirmPassword" style="width: 500px;"/></div>
				</div>
				<div class="table-foot" style="height: auto;">
					<textarea style="height: 360px;" readonly>${contract}</textarea>
					<form:label path="agree">
						<form:checkbox path="agree" value="true" style="width: 50px;" />
						I have read and agreed this agreement.
					</form:label>
					<form:button style="height: 50px;">REGISTER</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>