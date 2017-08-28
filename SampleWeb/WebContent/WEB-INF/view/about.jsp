<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="WEB-RES/css/dark-style.css"/>
<title>About Page</title>
</head>
<body>
<div class="page-header">
	<header>SAMPLE WEB - ABOUT PAGE</header>
</div>
<div class="page-center">
	<div class="tab-pane">
		<ul class="tab-title">
			<li><a href="#" id="server">Server Environment</a></li>
			<li><a href="#" id="system">System Environment</a></li>
			<li><a href="#" id="project">Project Presentation</a></li>
			<li><a href="#" id="resume">Author Resume</a></li>
		</ul>
		<div class="tab-content">
			<table id="about-table-server">
				<c:forEach items="${server}" var="item">
					<tr>
						<td class="about-table-key"><c:out value="${item.key}"/></td>
						<td class="about-table-value"><c:out value="${item.value}"/></td>
					</tr>
				</c:forEach>
			</table>
			<table id="about-table-system" style="display: none;">
				<c:forEach items="${system}" var="item">
					<tr>
						<td class="about-table-key"><c:out value="${item.key}"/></td>
						<td class="about-table-value"><c:out value="${item.value}"/></td>
					</tr>
				</c:forEach>
			</table>
			<table id="about-table-project" style="display: none;">
				<tr>
					<td class="about-table-key">AUTHOR</td>
					<td colspan="3" class="about-table-value">${project.author}</td>
				</tr>
				<tr>
					<td class="about-table-key">EMAIL</td>
					<td class="about-table-value" style="width: auto;">${project.email}</td>
					<td class="about-table-key">PHONE</td>
					<td class="about-table-value">${project.phone}</td>
				</tr>
				<tr>
					<td class="about-table-key">DESCRIPTION</td>
					<td colspan="3" class="about-table-value">${project.description}</td>
				</tr>
				<tr>
					<td colspan="4"><a href="#" class="about-edit">EDIT</a></td>
				</tr>
			</table>
			<table id="about-table-resume" style="display: none;">
				<tr>
					<td class="about-table-key">NAME</td>
					<td colspan="3" class="about-table-value">${resume.name}</td>
				</tr>
				<tr>
					<td class="about-table-key">EMAIL</td>
					<td class="about-table-value" style="width: auto;">${resume.email}</td>
					<td class="about-table-key">PHONE</td>
					<td class="about-table-value">${resume.phone}</td>
				</tr>
				<tr>
					<td colspan="4"><a href="#" class="about-edit">EDIT</a></td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div class="modal-dialog-backbone">
	<div class="modal-dialog-title">
		<button class="modal-close-button"><i class="fa fa-close" aria-hidden="true"></i></button>
	</div>
	<div class="modal-dialog-content">
		<section class="form-section" style="max-width: 640px;">
			<header>About Modal Dialog</header>
			<form:form method="POST" commandName="projectFormBean" cssClass="section-form">
				<div class="table-row">
					<div class="table-cell"><form:label path="author">AUTHOR</form:label></div>
					<div class="table-cell"><form:input path="author" style="width: 450px;"/></div>
				</div>
				<div class="table-row">
					<div class="table-cell"><form:label path="email">EMAIL</form:label></div>
					<div class="table-cell"><form:input path="email" style="width: 450px;"/></div>
				</div>
				<div class="table-row">
					<div class="table-cell"><form:label path="phone">PHONE</form:label></div>
					<div class="table-cell"><form:input path="phone" style="width: 450px;"/></div>
				</div>
				<div class="table-foot" style="height: auto;">
					<form:textarea path="description" style="height: 360px;"/>
					<hr>
					<form:button style="height: 50px;">SUBMIT</form:button>
				</div>
			</form:form>
		</section>
	</div>
</div>
</body>
<script src="WEB-RES/js/execute.js" type="text/javascript"></script>
<script src="WEB-RES/js/about.js" type="text/javascript"></script>
</html>