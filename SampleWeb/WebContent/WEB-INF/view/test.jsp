<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/dark-style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Page</title>
</head>
<body>
<ul class="tree-container" style="background-color: black;">
	<li>
	<div class="tree-body">
		<a href="#" class="tree-node">
			<i class="fa fa-plus-square-o" aria-hidden="true"></i>&nbsp;Title 1
		</a>
		<div class="tree-nodes">
			<a href="#" class="tree-leaf">
				&nbsp;&nbsp;&nbsp;
				<i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Title 1-1
			</a>
			<a href="#" class="tree-leaf">
				&nbsp;&nbsp;&nbsp;
				<i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Title 1-2
			</a>
			<a href="#" class="tree-leaf">
				&nbsp;&nbsp;&nbsp;
				<i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Title 1-3
			</a>
		</div>
	</div>
	</li>
	<li>
	<div class="tree-body">
		<a href="#" class="tree-node">
			<i class="fa fa-plus-square-o" aria-hidden="true"></i>&nbsp;Title
		</a>
		<div class="tree-nodes">
			<div class="tree-body">
				<a href="#" class="tree-node">
					&nbsp;&nbsp;&nbsp;
					<i class="fa fa-plus-square-o" aria-hidden="true"></i>&nbsp;Title
				</a>
				<div class="tree-nodes">
					<a href="#" class="tree-leaf">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Title
					</a>
					<a href="#" class="tree-leaf">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Title
					</a>
					<a href="#" class="tree-leaf">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Title
					</a>
				</div>
			</div>
			<div class="tree-body">
				<a href="#" class="tree-node">
					&nbsp;&nbsp;&nbsp;
					<i class="fa fa-plus-square-o" aria-hidden="true"></i>&nbsp;Title
				</a>
				<div class="tree-nodes">
					<a href="#" class="tree-leaf">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Title
					</a>
					<a href="#" class="tree-leaf">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Title
					</a>
					<a href="#" class="tree-leaf">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Title
					</a>
				</div>
			</div>
			<div class="tree-body">
				<a href="#" class="tree-node">
					&nbsp;&nbsp;&nbsp;
					<i class="fa fa-plus-square-o" aria-hidden="true"></i>&nbsp;Title
				</a>
				<div class="tree-nodes">
					<a href="#" class="tree-leaf">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Title
					</a>
					<a href="#" class="tree-leaf">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Title
					</a>
					<a href="#" class="tree-leaf">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Title
					</a>
				</div>
			</div>
		</div>
	</div>
	</li>
</ul>
</body>
</html>