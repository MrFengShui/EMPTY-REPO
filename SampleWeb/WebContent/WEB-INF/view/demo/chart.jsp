<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../WEB-RES/css/dark-style.css"/>
<title>JFreeChart Demonstration Page</title>
</head>
<body style="overflow-x: auto">
<c:choose>
	<c:when test="${condition == 'mono'}">
		
	</c:when>
	<c:when test="${condition == 'both'}">
		<div style="display: inline-block;">
			<header id="demo_chart_header">JFreeChart XXX Image</header>
			<div id="demo-chart-image">
				<img alt="" src="${img2d}" width="480" height="360">
				<img alt="" src="${img3d}" width="480" height="360">
			</div>
			<form:form method="POST" commandName="chartFormBean" cssClass="demo-chart-form">
				<form:label path="count">Count:</form:label>
				<form:input path="count"/>
				<form:label path="minBound">MinBound:</form:label>
				<form:input path="minBound"/>
				<form:label path="maxBound">MaxBound:</form:label>
				<form:input path="maxBound"/>
				<form:button>Generate</form:button>
			</form:form>
		</div>			
	</c:when>
	<c:otherwise>
		<header id="demo_chart_header">JFreeChart Sample Image</header>
		<div id="demo_chart_div">
			<c:if test="${!empty list}">
				<c:forEach items="${list}" var="item">
					<img alt="image" src="${item}" width="480" height="360" border="1">
				</c:forEach>
			</c:if>
		</div>
	</c:otherwise>	
</c:choose>
</body>
</html>