<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/dark-style.css"/>
<title>About Page</title>
</head>
<body>
<div class="page-container">
	<div class="page-header">
		<a href="login" class="page-header-logo"><img alt="" src="img/logo.png" width="75" height="75"></a>
		<div class="page-header-text">
			<label class="page-header-text-title div-left-center">SAMPLE WEB PROJECT</label>
			<label class="page-header-text-subtitle div-left-center">ABOUT PAGE</label>
		</div>
	</div>
	<div class="page-center div-center-center">
		<div class="tab-pane">
			<ul class="tab-title">
				<li><a href="about/server" target="about-frame">Server Environment</a></li>
				<li><a href="about/system" target="about-frame">System Environment</a></li>
				<li><a href="about/project" target="about-frame">Project Presentation</a></li>
				<li><a href="about/resume" target="about-frame">Author Resume</a></li>
			</ul>
			<div class="tab-content"><iframe src="about/server" name="about-frame"></iframe></div>
		</div>
	</div>
	<div class="page-footer"><span>Luan Songjian Copyright 2017-08-13</span></div>
</div>
</body>
</html>