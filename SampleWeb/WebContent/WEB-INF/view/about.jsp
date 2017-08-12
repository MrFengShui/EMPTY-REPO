<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="WEB-RES/css/about.css"/>
<title>About Page</title>
</head>
<body style="overflow-x: hidden;">
<table>
	<tr>
		<th id="about_table_key">Key</th>
		<th id="about_table_value">Value</th>
	</tr>
	<c:if test="${!empty list}">
		<c:forEach items="${list}" var="item">
			<tr>
				<td><c:out value="${item.key}"/></td>
				<td><c:out value="${item.value}"/></td>
			</tr>
		</c:forEach>
	</c:if>
	
	<c:forEach items="${rtbean.list}" var="item" varStatus="order">
		<c:choose>
			<c:when test="${order.index == 0}">
				<tr>
					<td rowspan="2 class="about_item_key"><c:out value="${rtbean.key}"/></td>
					<td class="about_item_value"><c:out value="${item}"/></td>
				</tr>
			</c:when>
			<c:otherwise>
				<td class="about_item_value"><c:out value="${item}"/></td>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<tr>
		<td rowspan="2" class="about_item_key"><c:out value="${vmbean.key}"/></td>
		<td class="about_item_value"><c:out value="${vmbean.value}"/></td>
	</tr>
	<tr>
		<td class="about_item_value"><c:out value="${specbean.value}"/></td>
	</tr>
	<tr>
		<td class="about_item_key"><c:out value="${serverbean.key}"/></td>
		<td class="about_item_value"><c:out value="${serverbean.value}"/></td>
	</tr>
	<tr>
		<td class="about_item_key"><c:out value="${osbean.key}"/></td>
		<td class="about_item_value"><c:out value="${osbean.value}"/></td>
	</tr>
	<c:forEach items="${userbean.list}" var="item" varStatus="order">
		<c:choose>
			<c:when test="${order.index == 0}">
				<tr>
					<td class="about_item_key" rowspan="4"><c:out value="${userbean.key}"/></td>
					<td class="about_item_value"><c:out value="${item}"/></td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr><td class="about_item_value"><c:out value="${item}"/></td></tr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<tr>
		<td class="about_item_key"><c:out value="${jarbean.key}"/></td>
		<td class="about_item_value">
			<c:forEach items="${jarbean.list}" var="item">
				<c:out value="${item}"/><br>
			</c:forEach>
		</td>
	</tr>
</table>
</body>
</html>