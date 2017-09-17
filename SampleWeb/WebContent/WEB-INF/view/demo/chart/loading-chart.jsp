<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../WEB-RES/css/dark-style.css"/>
<title>JFreeChart Demonstration Page</title>
</head>
<body>
<div class="page-header">
	<header>SAMPLE WEB - JFREECHART</header>
</div>
<div class="page-center" style="flex-wrap: wrap;">
	<section class="form-section">
		<header class="section-header">Chart Parameter Input</header>
		<form:form method="POST" commandName="chartFormBean" cssClass="section-form" style="max-width: 1000px;">
			<div class="table-foot"><form:input type="file" path="path"/></div>	
			<div class="table-foot"><form:button>Generate</form:button></div>				
		</form:form>
	</section>
	<c:choose>
		<c:when test="${condition == 'one'}">
			<div id="demo-chart-image">
				<img alt="" src="${img2dh}" width="${width}" height="${height}" border="1">
				<img alt="" src="${img2dv}" width="${width}" height="${height}" border="1">
			</div>
		</c:when>
		<c:when test="${condition == 'two'}">
			<div id="demo-chart-image">
				<img alt="" src="${img2dh}" width="${width}" height="${height}" border="1">
				<img alt="" src="${img2dv}" width="${width}" height="${height}" border="1">
			</div>
			<div id="demo-chart-image">
				<img alt="" src="${img3dh}" width="${width}" height="${height}" border="1">
				<img alt="" src="${img3dv}" width="${width}" height="${height}" border="1">
			</div>
		</c:when>
	</c:choose>		
</div>
</body>
</html>