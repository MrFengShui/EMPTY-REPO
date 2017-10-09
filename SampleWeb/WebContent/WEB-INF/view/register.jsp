<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/dark-style.css" />
<title>Register Page</title>
</head>
<body style="height: auto;">
<div class="page-container">
	<div class="page-header">
		<a href="login" class="page-header-logo"><img alt="" src="img/logo.png" width="75" height="75"></a>
		<div class="page-header-text">
			<label class="page-header-text-title title-font">SAMPLE WEB PROJECT</label>
			<label class="page-header-text-subtitle subtitle-font">REGISTER PAGE</label>
		</div>
	</div>
	<div class="page-center div-center-center" style="padding-top: 10px;padding-bottom: 10px;">
		<form:form method="POST" commandName="registerBean" style="width: 880px;" cssClass="section-form">
			<header class="section-form-header header-font">
				<i class="fa fa-id-card" aria-hidden="true"></i>&nbsp;SIGN UP
			</header>
			<div class="section-form-cell">
				<form:label path="firstname" class="medium-text-font">FIRSTNAME</form:label>
				<form:input path="firstname"/>
			</div>
			<div class="section-form-cell">
				<form:label path="lastname" class="medium-text-font">LASTNAME</form:label>
				<form:input path="lastname"/>
			</div>
			<div class="section-form-cell">
				<form:label path="dateOfBirth" class="medium-text-font">DATE OF BIRTH</form:label>
				<form:input type="date" path="dateOfBirth"/>
			</div>
			<div class="section-form-cell">
				<form:label path="email" class="medium-text-font">EMAIL</form:label>
				<form:input type="email" path="email"/>
			</div>
			<div class="section-form-cell">
				<form:label path="gender" class="medium-text-font">GENDER</form:label>
				<form:radiobuttons path="gender" items="${genders}"/>
			</div>
			<div class="section-form-cell">
				<form:label path="nation" class="medium-text-font">NATIONALITY</form:label>
				<form:select path="nation">
					<form:option value="None">----- Select -----</form:option>
					<form:options items="${nations}" />
				</form:select>
			</div>
			<div class="section-form-cell">
				<form:label path="username" class="medium-text-font">USERNAME</form:label>
				<form:input path="username"/>
			</div>
			<div class="section-form-cell">
				<form:label path="password" class="medium-text-font">PASSWORD</form:label>
				<form:password path="password"/>
			</div>
			<div class="section-form-cell">
				<form:label path="confirmPassword" class="medium-text-font">CONFIRM PASSWORD</form:label>
				<form:password path="confirmPassword"/>
			</div>			
			<div class="section-form-cell">
				<form:label path="agree" class="medium-text-font" style="width: 100%;">
					<form:checkbox path="agree" value="true" style="width: 50px;"/>
					I have read and agreed this <a class="link" href="#" onclick="modal_dialog_show();">agreement</a>.
				</form:label>
			</div>
			<div class="section-form-cell"><form:button class="medium-text-font" style="height: 50px;">REGISTER</form:button></div>
		</form:form>
	</div>
	<div class="page-footer"><span class="medium-text-font div-center-center">Luan Songjian Copyright 2017-08-13</span></div>
</div>
<div class="modal-dialog-backbone">
	<div class="modal-dialog-head">
		<header class="modal-dialog-title big-header-font div-left-center">SampleWeb Registering Agreement</header>			
		<button class="modal-close-button big-text-font" onclick="modal_dialog_hide();">
			<i class="fa fa-close" aria-hidden="true"></i>
		</button>
	</div>
	<div class="modal-dialog-body">
		<textarea class="textarea medium-border-negative small-text-font" style="height: 800px;" readonly>${contract}</textarea>
	</div>
</div>
</body>
<script src="js/window.js" type="text/javascript"></script>
</html>