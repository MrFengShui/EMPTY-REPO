<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/dark-style.css"/>
<title>Login Page</title>
</head>
<body>
<div class="page-container">
	<div class="page-header">
		<a href="login" class="page-header-logo"><img alt="" src="img/logo.png" width="75" height="75"></a>
		<div class="page-header-text">
			<label class="page-header-text-title title-font">SAMPLE WEB PROJECT</label>
			<label class="page-header-text-subtitle subtitle-font">LOGIN PAGE</label>
		</div>
	</div>
	<div class="page-center div-center-center">
		<form:form method="POST" commandName="indexBean" style="width: 640px;height: 326px;" cssClass="section-form medium-border-negative-shadow">
			<header class="section-form-header big-header-font div-left-center">
				<i class="fa fa-id-card" aria-hidden="true"></i>&nbsp;SIGN IN
			</header>
			<div class="section-form-cell">
				<form:label path="username" class="medium-text-font">USERNAME</form:label>
				<form:input path="username"/>
			</div>
			<div class="section-form-cell">
				<form:label path="password" class="medium-text-font">PASSWORD</form:label>
				<form:password path="password"/>
			</div>
			<div class="section-form-cell">
				<form:button class="button-border medium-text-font div-center-center">LOGIN</form:button>
			</div>
			<div class="section-form-cell" style="flex-wrap: nowrap;">
				<a href="register" class="button-fill medium-text-font div-center-center">Register</a> 
				<a href="question" class="button-fill medium-text-font div-center-center">Question</a> 
				<a href="about" class="button-fill medium-text-font div-center-center">About</a>
			</div>
		</form:form>
	</div>
	<div class="page-footer"><span class="big-text-font div-center-center">Luan Songjian Copyright 2017-08-13</span></div>
</div>
</body>
</html>