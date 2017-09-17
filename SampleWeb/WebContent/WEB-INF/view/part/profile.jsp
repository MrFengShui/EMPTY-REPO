<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="profile-section">
	<c:choose>
		<c:when test="${not empty username}">
			<div class="profile-section-icon div-center-center">
				<img alt="" src="${profile}" height="100%">
			</div>
			<div class="profile-section-text medium-text-font div-center-center">
				${username}&nbsp;&nbsp;
				<a href="#"><i class="fa fa-caret-down" aria-hidden="true"></i></a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="profile-section-icon div-center-center">
				<i class="fa fa-user-circle" aria-hidden="true"></i>
			</div>
			<div class="profile-section-text small-text-font div-center-center">
				Account&nbsp;&nbsp;
				<a href="#"><i class="fa fa-caret-down" aria-hidden="true"></i></a>
			</div>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>