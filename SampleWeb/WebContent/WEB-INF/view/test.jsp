<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri = "/WEB-INF/tag/tag.tld" prefix = "t"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/dark-style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Page</title>
</head>
<body class="div-center-center" style="background-color: crimson;">
<div class="slide-bar thin-border" style="width: 350px;height: 50px;">
	<span class="slide-bar-left"></span>
	<button class="medium-border"></button>
	<span class="slide-bar-right"></span>
</div>
</body>
<script src="js/execute.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
<script src="js/component.js" type="text/javascript" onload="show_tabbed_panel();"></script>
</html>