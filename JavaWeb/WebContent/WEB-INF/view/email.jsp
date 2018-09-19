<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YouMediaStudio - EMAIL</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/slate/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
	<jsp:include page="email/head.jsp" flush="true" />
	<div class="row p-0" id="email-middle">
		<jsp:include page="email/nav.jsp" flush="true" />
		<jsp:include page="email/main.jsp" flush="true" />
	</div>
	<jsp:include page="common/foot.jsp" flush="true" />
</div>
<jsp:include page="modal/mail.jsp" flush="true" />
</body>
  <script type="text/javascript">
    $(document).ready(function() {
      	var height = $(window).height();

        $(window).ready(function() {
        	$('#email-middle').css('height', height + "px");
        });

      	$(window).resize(function() {
        	$('#email-middle').css('height', height + "px");
        });
    });
  </script>
</html>