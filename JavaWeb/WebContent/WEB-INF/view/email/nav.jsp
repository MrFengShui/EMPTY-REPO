<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-auto bg-light p-2" style="width: 240px;">
		<button class="btn btn-primary btn-block" data-toggle="modal"
			data-target="#email-modal">NEW EMAIL</button>
		<button class="btn btn-secondary btn-block">REFRESH</button>
		<hr class="bg-primary">
		<div class="card">
			<div class="card-header bg-primary">HEADER</div>
			<div class="card-body">
				<div class="nav flex-column nav-pills" id="v-pills-tab"
					role="tablist" aria-orientation="vertical">
					<a class="nav-link active" id="v-pills-inbox-tab"
						data-toggle="pill" href="#v-pills-inbox" role="tab"
						aria-controls="v-pills-inbox" aria-selected="true">INBOX</a> <a
						class="nav-link" id="v-pills-spam-tab" data-toggle="pill"
						href="#v-pills-spam" role="tab" aria-controls="v-pills-spam"
						aria-selected="false">SPAM</a> <a class="nav-link"
						id="v-pills-trash-tab" data-toggle="pill" href="#v-pills-trash"
						role="tab" aria-controls="v-pills-trash" aria-selected="false">TRASH</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>