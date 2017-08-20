<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="WEB-RES/css/dark-style.css"/>
<title>Main Page</title>
</head>
<body>
<div id="main_div">
	<div><jsp:include page="part/top.jsp"/></div>
	<hr>
	<div style="display: inline-flex;width: 100%;"><jsp:include page="part/center.jsp"/></div>
	<hr>
	<div><jsp:include page="part/bottom.jsp"/></div>
</div>
</body>
<script src="WEB-RES/js/execute.js" type="text/javascript"></script>
<script src="WEB-RES/js/main.js" type="text/javascript" onload="show_date_time();"></script>
</html>