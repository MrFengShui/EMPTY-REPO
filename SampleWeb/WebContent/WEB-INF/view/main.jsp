<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="WEB-RES/css/dark-style.css"/>
<title>Main Page</title>
</head>
<body onresize="match_size()">
<div id="main_div">
	<div><jsp:include page="part/top.jsp"/></div>
	<hr>
	<div style="display: inline-flex;width: 100%;">
		<jsp:include page="part/left.jsp"/>
		<hr>
		<iframe src="" name="page_frame"></iframe>
	</div>
	<hr>
	<div><jsp:include page="part/bottom.jsp"/></div>
</div>
</body>
<script src="WEB-RES/js/execute.js" type="text/javascript"></script>
<script src="WEB-RES/js/main.js" type="text/javascript" onload="show_date_time();match_size();"></script>
</html>