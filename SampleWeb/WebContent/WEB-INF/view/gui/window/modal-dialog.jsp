<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="modal-dialog-backbone">
	<div class="modal-dialog-head">
		<header class="modal-dialog-title header-font div-left-center">Modal Dialog Title</header>			
		<button class="modal-close-button big-text-font" onclick="hide_modal_dialog();"><i class="fa fa-close" aria-hidden="true"></i></button>
	</div>
	<div class="modal-dialog-body"></div>
</div>
</body>
</html>