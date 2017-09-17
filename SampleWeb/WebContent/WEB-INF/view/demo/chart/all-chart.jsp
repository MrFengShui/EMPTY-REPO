<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/dark-style.css"/>
<title></title>
</head>
<body>
<div class="page-header">
	<header>JFREECHART DEMO - ALL CHARTS SHOW</header>
</div>
<div class="page-center" style="flex-wrap: wrap;">
	<section class="form-section">
		<header class="section-header">Chart Parameter Input</header>
		<form:form method="POST" commandName="chartFormBean" cssClass="section-form" style="max-width: 1000px;">
			<div class="table-head" style="flex-wrap: nowrap;">
				<form:label path="count">Count:</form:label>
				<form:input path="count" style="width: 100px;"/>
				<form:label path="minBound">MinBound:</form:label>
				<form:input path="minBound" style="width: 100px;"/>
				<form:label path="maxBound">MaxBound:</form:label>
				<form:input path="maxBound" style="width: 100px;"/>
			</div>
			<div class="table-foot"><form:button>Generate</form:button></div>				
		</form:form>
	</section>
	<div id="demo-chart-div">
		<c:if test="${!empty chartlist}">
			<c:forEach items="${chartlist}" var="item">
				<section class="title-section">
					<header class="title-header">${item.name}</header>
					<div class="title-content">
						<c:forEach items="${item.list}" var="list">
							<img alt="image" src="${list}" width="${width}" height="${height}" border="1">
						</c:forEach>
					</div>
				</section>
			</c:forEach>
		</c:if>
	</div>
</div>
</body>
</html>