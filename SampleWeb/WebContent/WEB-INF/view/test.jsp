<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<body class="div-center-center" style="background-color: black;padding: 5px;">
<jsp:include page="gui/panel/pagination.jsp"/>
</body>
<script src="js/test.js" type="text/javascript"></script>
<script src="js/panel.js" type="text/javascript"></script>
<script src="js/window.js" type="text/javascript"></script>
<script src="js/control.js" type="text/javascript"></script>
<script src="js/execute.js" type="text/javascript"></script>
</html>