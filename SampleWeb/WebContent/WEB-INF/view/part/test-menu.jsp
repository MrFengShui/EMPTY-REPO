<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="menu-list" id="${id}">
	<c:forEach items="${list}" var="item">
		<a href="#" class="menu-item medium-text-font div-center-center" id="${item.itemID}">
			${item.itemText}&nbsp;
			<i class="fa fa-chevron-right" aria-hidden="true"></i>
		</a>
	</c:forEach>
</div>
</body>
</html>