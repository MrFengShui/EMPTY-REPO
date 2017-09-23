<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/dark-style.css"/>
</head>
<body>
<table class="key-value-table">
	<tr>
		<td class="table-key medium-border">NAME</td>
		<td colspan="3" class="table-value medium-border">${resume.name}</td>
	</tr>
	<tr>
		<td class="table-key medium-border">EMAIL</td>
		<td class="table-value medium-border" style="width: auto;">${resume.email}</td>
		<td class="table-key medium-border">PHONE</td>
		<td class="table-value medium-border">${resume.phone}</td>
	</tr>
	<tr>
		<td colspan="4" class="table-value medium-border">
			<a href="#" class="about-edit" onclick="show_modal_dialog();">EDIT</a>
		</td>
	</tr>
</table>
<jsp:include page="../component/modal-dialog.jsp"/>
</body>
<script src="../js/about.js" type="text/javascript"></script>
</html>