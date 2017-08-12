<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="WEB-RES/css/test.css"/>
<title>Test Page</title>
</head>
<body>
<h1>${message}</h1>
<table id="test_table">
	<tr>
		<th>Sample ID</th>
		<th>Sample Name</th>
	</tr>
	<c:if test="${!empty list}">
		<c:forEach items="${list}" var="item">
			<tr>
				<td><c:out value="${item.sampleID}"/></td>
				<td><c:out value="${item.sampleName}"/></td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<p>Username: ${username}</p>
<br>
<p>Password: ${password}</p>
</body>
</html>