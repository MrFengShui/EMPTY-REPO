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
<div class="tabbed-panel-vertical">
	<div class="tabbed-panel-items medium-border div-left-center">
		<div class="tabbed-panel-item" id="tabbed-1-selected">
			<span class="medium-text-font div-center-center">TITLE-1</span>
			<button class="medium-text-font div-center-center"><i class="fa fa-times" aria-hidden="true"></i></button>
		</div>
		<div class="tabbed-panel-item" id="tabbed-2">
			<span class="medium-text-font div-center-center">TITLE-2</span>
			<button class="medium-text-font div-center-center"><i class="fa fa-times" aria-hidden="true"></i></button>
		</div>
		<div class="tabbed-panel-item" id="tabbed-3">
			<span class="medium-text-font div-center-center">TITLE-3</span>
			<button class="medium-text-font div-center-center"><i class="fa fa-times" aria-hidden="true"></i></button>
		</div>
		<div class="tabbed-panel-item" id="tabbed-4">
			<span class="medium-text-font div-center-center">TITLE-4</span>
			<button class="medium-text-font div-center-center"><i class="fa fa-times" aria-hidden="true"></i></button>
		</div>
		<div style="width: 100%;"></div>
	</div>
	<div class="tabbed-panel-body medium-border">
		<div class="tabbed-panel-content" id="tabbed-1-content" style="background-color: yellow;"></div>
		<div class="tabbed-panel-content" id="tabbed-2-content" style="background-color: green;"></div>
		<div class="tabbed-panel-content" id="tabbed-3-content" style="background-color: red;"></div>
		<div class="tabbed-panel-content" id="tabbed-4-content" style="background-color: blue;"></div>
	</div>
</div>
<!-- <div class="tabbed-panel-vertical">
	<div class="tabbed-panel-body medium-border">
		<div class="tabbed-panel-content" id="tabbed-5-content" style="background-color: yellow;"></div>
		<div class="tabbed-panel-content" id="tabbed-6-content" style="background-color: green;"></div>
		<div class="tabbed-panel-content" id="tabbed-7-content" style="background-color: red;"></div>
		<div class="tabbed-panel-content" id="tabbed-8-content" style="background-color: blue;"></div>
	</div>
	<div class="tabbed-panel-items medium-border div-left-center">
		<div class="tabbed-panel-item" id="tabbed-5-selected">
			<span class="medium-text-font div-center-center">TITLE-1</span>
			<button class="medium-text-font div-center-center"><i class="fa fa-times" aria-hidden="true"></i></button>
		</div>
		<div class="tabbed-panel-item" id="tabbed-6">
			<span class="medium-text-font div-center-center">TITLE-2</span>
			<button class="medium-text-font div-center-center"><i class="fa fa-times" aria-hidden="true"></i></button>
		</div>
		<div class="tabbed-panel-item" id="tabbed-7">
			<span class="medium-text-font div-center-center">TITLE-3</span>
			<button class="medium-text-font div-center-center"><i class="fa fa-times" aria-hidden="true"></i></button>
		</div>
		<div class="tabbed-panel-item" id="tabbed-8">
			<span class="medium-text-font div-center-center">TITLE-4</span>
			<button class="medium-text-font div-center-center"><i class="fa fa-times" aria-hidden="true"></i></button>
		</div>
		<div style="width: 100%;"></div>
	</div>
</div> -->
</body>
<script src="js/panel.js" type="text/javascript" onload="show_tabbed_panel();"></script>
</html>