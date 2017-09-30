<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="display: block;">
<div class="split-panel-horizontal">
	<div class="split-panel-container" style="background-color: green;"></div>
	<div class="split-panel-separator-vertical"></div>
	<div class="split-panel-container" style="background-color: red;"></div>
</div>
<div class="split-panel-vertical">
	<div class="split-panel-container" style="background-color: green;"></div>
	<div class="split-panel-separator-horizontal"></div>
	<div class="split-panel-container" style="background-color: red;"></div>
</div>
</body>
<script src="js/panel.js" type="text/javascript"></script>
</html>