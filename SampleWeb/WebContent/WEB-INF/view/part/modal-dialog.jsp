<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="modal-dialog-backbone">
	<div class="modal-dialog-title">
		<button class="modal-close-button" onclick="hide_modal_dialog();"><i class="fa fa-close" aria-hidden="true"></i></button>
	</div>
	<div class="modal-dialog-content">
		<form:form method="POST" commandName="projectFormBean" cssClass="section-form">
			<header class="section-form-header">About Modal Dialog</header>			
			<div class="section-form-cell">
				<form:label path="author">AUTHOR</form:label>
				<form:input path="author"/>
			</div>
			<div class="section-form-cell">
				<form:label path="email">EMAIL</form:label>
				<form:input path="email"/>
			</div>
			<div class="section-form-cell">
				<form:label path="phone">PHONE</form:label>
				<form:input path="phone"/>
			</div>
			<div class="section-form-cell" style="height: auto;">
				<form:label path="description">DESCRIPTION</form:label>
				<form:textarea path="description" style="height: 360px;"/>
			</div>
			<div class="section-form-cell">
				<form:button style="height: 50px;">SUBMIT</form:button>
			</div>
		</form:form>
	</div>
</div>
</body>
<script src="../js/about.js" type="text/javascript"></script>
</html>