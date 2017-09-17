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
<div class="demo-chart-body">
	<c:choose>
		<c:when test="${condition == 'one'}">
			<div class="demo-chart-cell">
				<img alt="" src="${img2d}" width="${width}" height="${height}">
				<hr>
				<img alt="" src="${img3d}" width="${width}" height="${height}">
			</div>
		</c:when>
		<c:when test="${condition == 'two'}">
			<div class="demo-chart-cell">
				<img alt="" src="${img2dh}" width="${width}" height="${height}">
				<hr>
				<img alt="" src="${img2dv}" width="${width}" height="${height}">
			</div>
			<hr>
			<div class="demo-chart-cell">
				<img alt="" src="${img3dh}" width="${width}" height="${height}">
				<hr>
				<img alt="" src="${img3dv}" width="${width}" height="${height}">
			</div>
		</c:when>
	</c:choose>
</div>
</body>
</html>