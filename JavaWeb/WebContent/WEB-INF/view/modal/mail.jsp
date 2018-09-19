<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="modal fade" role="dialog"
		aria-labelledby="email-modal-label" aria-hidden="true" tabindex="-1"
		id="email-modal">
		<div class="modal-dialog modal-dialog-centered modal-lg"
			role="document">
			<div class="modal-content">
				<div class="modal-header bg-dark">
					<h5 class="modal-title" id="email-modal-label">New Email</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="#" method="post" class="">
						<div class="input-group p-1">
							<div class="input-group-prepend">
								<span class="input-group-text d-flex justify-content-center"
									style="width: 96px;">TO</span>
							</div>
							<input type="email" class="form-control"
								placeholder="example@gmail.com">
						</div>
						<div class="input-group p-1">
							<div class="input-group-prepend">
								<span class="input-group-text d-flex justify-content-center"
									style="width: 96px;">SUBJECT</span>
							</div>
							<input type="text" class="form-control"
								placeholder="Emergent Notification">
						</div>
						<div class="input-group p-1" style="height: 256px;">
							<textarea class="form-control"
								placeholder="Write Your Content Here"></textarea>
						</div>
						<div class="input-group p-1">
							<div class="input-group-prepend">
								<span class="input-group-text d-flex justify-content-center"
									style="width: 96px;">ATTACH</span>
							</div>
							<div class="custom-file">
								<input type="file" class="custom-file-input" id="attach-input"
									aria-describedby="attach-input"> <label
									class="custom-file-label" for="attach-input"></label>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer bg-light">
					<div class="w-50">
						<button type="button" class="btn btn-primary btn-block"
							data-dismiss="modal">Send</button>
					</div>
					<div class="w-50">
						<button type="button" class="btn btn-secondary btn-block"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>