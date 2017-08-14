<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="WEB-RES/css/dark-style.css"/>
<title>Index Page</title>
</head>
<body>
<h1 id="index_header_1">My First JSP Web Project</h1>
<div id="index_section_div">
	<section id="index_section">
		<h2 id="index_header_2">Sign In</h2>
		<form:form method="POST" action="index" commandName="indexBean">
			<table id="index_form_table">
				<tr>
					<td class="index_table_label"><form:label path="">Username</form:label></td>
					<td><form:input path="username"/></td>
				</tr>
				<tr>
					<td class="index_table_label"><form:label path="">Password</form:label></td>
					<td><form:password name="password" path="password"/></td>
				</tr>
				<tr>
					<td id="index_table_control" colspan="2"><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form:form>
	</section>
</div>
</body>
</html>