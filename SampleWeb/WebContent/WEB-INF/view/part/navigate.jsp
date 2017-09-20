<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="page-header-nav">
	<a href="#" class="date-time-text big-text-font div-center-center"></a>
	<nav class="menu-bar">
		<c:forEach items="${root}" var="item">
			<a href="#" class="menu-title medium-text-font div-center-center" id="${item.ID}">
				<i class="fa fa-life-ring" aria-hidden="true"></i>
				&nbsp;${item.text}
			</a>
		</c:forEach>
		<span style="width: 100%;"></span>
	</nav>
	<c:forEach items="${nodes}" var="node">
		<div class="menu-list" id="${node.ID}-list">
			<c:forEach items="${node.list}" var="item">
				<c:choose>
					<c:when test="${item.type == 'item'}">
						<a href="${item.link}" class="menu-item medium-text-font div-left-center" id="${item.ID}">
							${item.icon}&nbsp;${item.text}&nbsp;
						</a>
					</c:when>
					<c:otherwise>
						<a href="${item.link}" class="menu-item medium-text-font div-left-center" id="${item.ID}">
							${item.icon}&nbsp;${item.text}&nbsp;
							<i class="fa fa-chevron-right" aria-hidden="true"></i>
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</c:forEach>
</div>
</body>
<script src="js/execute.js" type="text/javascript"></script>
<script src="js/component.js" type="text/javascript"></script>
</html>