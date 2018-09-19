<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>YouMediaStudio - HOME</title>
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
<style>
#index-middle-left::-webkit-scrollbar {
	display: none;
}

#index-middle-right::-webkit-scrollbar {
	display: none;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="index/head.jsp" flush="true" />
		<div class="row bg-light p-0" id="index-middle">
			<jsp:include page="index/main.jsp" flush="true" />
			<jsp:include page="index/nav.jsp" flush="true" />
		</div>
		<jsp:include page="common/foot.jsp" flush="true" />
	</div>
	<jsp:include page="modal/sign-in.jsp" flush="true" />
</body>
<script type="text/javascript">
	$(document).ready(function() {
		var height = $(window).height();

		$(window).ready(function() {
			$('#index-middle').css('height', height + "px");
		});

		$(window).resize(function() {
			$('#index-middle').css('height', height + "px");
		});

		$('#index-middle-left').ready(function() {
			$('#index-middle-left').css({
				'height' : height + 'px',
				'overflow-y' : 'auto'
			});
		});

		$('#index-middle-left').resize(function() {
			$('#index-middle-left').css({
				'height' : height + 'px',
				'overflow-y' : 'auto'
			});
		});

		$('#index-middle-right').ready(function() {
			$('#index-middle-right').css({
				'width' : '200px',
				'height' : height + 'px',
				'overflow-y' : 'auto'
			});
		});

		$('#index-middle-right').resize(function() {
			$('#index-middle-right').css({
				'width' : '200px',
				'height' : height + 'px',
				'overflow-y' : 'auto'
			});
		});
	});
</script>
</html>