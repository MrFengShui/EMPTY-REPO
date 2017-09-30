<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="border-panel">
	<div class="border-panel-top" style="background-color: black;height:80px;"></div>
	<div class="border-panel-body">
		<div class="border-panel-left" style="background-color: gold;width:200px;"></div>
		<div class="border-panel-center" style="background-color: yellow;"></div>
		<div class="border-panel-right" style="background-color: green;width:200px;"></div>
	</div>
	<div class="border-panel-bottom" style="background-color: red;height:40px;"></div>
</div>
</body>
<script src="js/panel.js" type="text/javascript" onload="border_panel_match_size()"></script>
</html>