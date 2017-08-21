<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../WEB-RES/css/dark-style.css"/>
<title>JFreeChart Demonstration Page</title>
</head>
<body>
<h1 id="demo_chart_header">JFreeChart Sample Image</h1>
<div id="demo_chart_div">
	<c:if test="${!empty list}">
		<c:forEach items="${list}" var="item">
			<img alt="image" src="${item}" width="480" height="360" border="1" style="margin: 10px;">
		</c:forEach>
	</c:if>
</div>
</body>
</html>