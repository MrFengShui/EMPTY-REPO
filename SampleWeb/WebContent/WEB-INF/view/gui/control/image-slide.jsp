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
<div class="image-slide medium-border-shadow" style="width: 800px; height: 600px;">
	<div class="image-content div-center-center"><img src="${current}" width="100%" height="100%"></div>
	&nbsp;<hr>&nbsp;
	<div class="image-items">
		<c:forEach items="${images}" var="image" varStatus="index">
			<c:choose>
				<c:when test="${index.index == 0}">
					<div class="image-item medium-border div-center-center" style="background-color: rgb(32, 32, 32);"><img src="${image}"  width="100%" height="100%"></div>
				</c:when>
				<c:otherwise>
					<div class="image-item medium-border div-center-center"><img src="${image}"  width="100%" height="100%"></div>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>
</div>
</body>
<script src="../js/about.js" type="text/javascript"></script>
</html>