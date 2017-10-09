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
<div class="pagination" style="height: 100%;">
	<div class="pagination-bar div-center-center">
		<button class="pagination-button medium-text-font" id="page-top-head">
			<i class="fa fa-fast-backward" aria-hidden="true"></i>
		</button>
		<button class="pagination-button medium-text-font" id="page-top-previous">
			<i class="fa fa-backward" aria-hidden="true"></i>
		</button>
		<button class="pagination-button medium-text-font" id="page-top-1-selected">1</button>
		<button class="pagination-button medium-text-font" id="page-top-2">2</button>
		<button class="pagination-button medium-text-font" id="page-top-3">3</button>
		<button class="pagination-button medium-text-font" id="page-top-next">
			<i class="fa fa-forward" aria-hidden="true"></i>
		</button>
		<button class="pagination-button medium-text-font" id="page-top-foot">
			<i class="fa fa-fast-forward" aria-hidden="true"></i>
		</button>
	</div>
	<div class="pagination-body">
		<div class="pagination-content" id="page-1-content" style="background-color: red;"></div>
		<div class="pagination-content" id="page-2-content" style="background-color: green;"></div>
		<div class="pagination-content" id="page-3-content" style="background-color: blue;"></div>
	</div>
	<div class="pagination-bar div-center-center">
		<button class="pagination-button medium-text-font" id="page-bottom-head">
			<i class="fa fa-fast-backward" aria-hidden="true"></i>
		</button>
		<button class="pagination-button medium-text-font" id="page-bottom-previous">
			<i class="fa fa-backward" aria-hidden="true"></i>
		</button>
		<button class="pagination-button medium-text-font" id="page-bottom-1-selected">1</button>
		<button class="pagination-button medium-text-font" id="page-bottom-2">2</button>
		<button class="pagination-button medium-text-font" id="page-bottom-3">3</button>
		<button class="pagination-button medium-text-font" id="page-bottom-next">
			<i class="fa fa-forward" aria-hidden="true"></i>
		</button>
		<button class="pagination-button medium-text-font" id="page-bottom-foot">
			<i class="fa fa-fast-forward" aria-hidden="true"></i>
		</button>
	</div>
</div>
</body>
<script src="js/panel.js" type="text/javascript" onload="show_pagination(1, 3)"></script>
</html>