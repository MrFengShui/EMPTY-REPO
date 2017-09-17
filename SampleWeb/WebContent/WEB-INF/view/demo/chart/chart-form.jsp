<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/dark-style.css"/>
<title>JFreeChart Demonstration Page</title>
</head>
<body>
<form:form method="POST" commandName="chartFormBean" style="border-width: 0;" cssClass="section-form">
	<header class="section-form-header">
		<i class="fa fa-id-card" aria-hidden="true"></i>&nbsp;CONDITION
	</header>
	<div class="section-form-cell">
		<form:label path="count">Count</form:label>
		<form:input path="count" style="width: 120px;"/>
	</div>
	<div class="section-form-cell">
		<form:label path="minBound">MinBound</form:label>
		<form:input path="minBound" style="width: 120px;"/>
	</div>
	<div class="section-form-cell">
		<form:label path="maxBound">MaxBound</form:label>
		<form:input path="maxBound" style="width: 120px;"/>
	</div>
	<div class="section-form-cell"><form:button>Generate</form:button></div>				
</form:form>
</body>
</html>