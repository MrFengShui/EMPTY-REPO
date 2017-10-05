<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri = "/WEB-INF/tag/tag.tld" prefix = "cc"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/dark-style.css"/>
<title>Main Page</title>
</head>
<body>
<div class="page-container">
	<div class="page-header">
		<a href="login" class="page-header-logo"><img alt="" src="img/logo.png" width="75" height="75"></a>
		<div class="page-header-text">
			<label class="page-header-text-title title-font">SAMPLE WEB PROJECT</label>
			<label class="page-header-text-subtitle subtitle-font">INDEX PAGE</label>
		</div>
		<jsp:include page="part/navigate.jsp"/>
		<jsp:include page="part/profile.jsp"/>
	</div>
	<hr>
	<div class="page-center div-center-center" style="height: calc(100% - 135px);">
		<div class="tree"></div>
		<hr style="height: 100%;">
		<iframe src="" name="page_frame" id="main_page_frame"></iframe>
	</div>
	<hr>
	<div class="page-footer"><span class="big-text-font div-center-center">Luan Songjian Copyright 2017-08-13</span></div>
</div>
</body>
<script src="js/execute.js" type="text/javascript"></script>
<script src="js/control.js" type="text/javascript" onload="tree_build(${json}, ${size});"></script>
<script src="js/main.js" type="text/javascript" onload="show_date_time();"></script>
</html>