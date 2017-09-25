<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<table class="key-value-table">
	<c:forEach items="${server}" var="item">
		<tr>
			<td class="table-key medium-border"><c:out value="${item.key}"/></td>
			<td class="table-value medium-border"><c:out value="${item.value}"/></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>