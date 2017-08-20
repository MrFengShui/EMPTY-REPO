<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<ul id="main_center_list">
	<c:if test="${!empty outerlist}">
		<c:forEach items="${outerlist}" var="outer">
			<li class="main_item_node">
				<div class="main_item_header">
					<button class="main_item_button">+</button>
					<h2>${outer.header}</h2>
				</div>
				<div class="main_item_content">
					<c:if test="${!empty outer.list}">
						<c:forEach items="${outer.list}" var="inner">
							<a href="demo/chart" target="page_frame" class="main_item_link">${inner}</a>
						</c:forEach>
					</c:if>
				</div>
			</li>
		</c:forEach>
	</c:if>
</ul>
<hr>
<iframe src="" name="page_frame"></iframe>
</body>
</html>