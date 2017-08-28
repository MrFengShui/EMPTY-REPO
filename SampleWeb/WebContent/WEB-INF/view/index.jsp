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
<body>
<div class="page-header"><jsp:include page="part/top.jsp"/></div>
<hr>
<div class="page-center" style="height: 88.5%">
	<jsp:include page="part/left.jsp"/>
	<hr style="height: 100%;">
	<iframe src="" name="page_frame" id="main_page_frame"></iframe>
</div>
<hr>
<div class="page-bottom"><jsp:include page="part/bottom.jsp"/></div>
</body>
<script src="WEB-RES/js/execute.js" type="text/javascript"></script>
<script src="WEB-RES/js/main.js" type="text/javascript" onload="show_date_time();"></script>
</html>