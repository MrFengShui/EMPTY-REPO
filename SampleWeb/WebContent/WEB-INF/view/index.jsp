<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="WEB-RES/css/index.css"/>
<title>Index Page</title>
</head>
<body>
<section id="index_section">
<h1>Sign In</h1>
<div>
	<form:form method="POST" action="index" commandName="indexBean">
		<table>
			<tr>
				<td class="table_label">Username</td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td class="table_label">Password</td>
				<td><form:password name="password" path="password"/></td>
			</tr>
			<tr>
				<td></td>
				<td id="table_control"><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form:form>
</div>
</section>
</body>
</html>