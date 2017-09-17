<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../../css/dark-style.css"/>
<title>JFreeChart Demonstration Page</title>
</head>
<body>
<div class="page-container" style="min-width: 1150px;height: auto;">
	<div class="page-header">
		<a href="login" class="page-header-logo"><img alt="" src="../../img/replace.png" width="75" height="75"></a>
		<div class="page-header-text">
			<label class="page-header-text-title div-left-center">JFREECHART DEMONSTRATION</label>
			<label class="page-header-text-subtitle div-left-center">BAR CHART - RANDOM NUMBER</label>
		</div>
	</div>
	<div class="page-center div-center-center" style="flex-wrap: wrap;padding: 5px;">
		<div class="demo-chart-show medium-border">
			<jsp:include page="chart-layout.jsp"/>
			<jsp:include page="chart-form.jsp"/>
		</div>
		<jsp:include page="../file-info.jsp"/>
	</div>	
</div>
</body>
</html>