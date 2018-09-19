<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="modal fade" id="signin-modal">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header bg-dark">
					<h5 class="modal-title">SIGN IN</h5>
					<button type="button" class="close" data-dismiss="modal">
						<span>×</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="#" method="post" class="">
						<div class="input-group p-1">
							<div class="input-group-prepend">
								<span class="input-group-text" style="width: 96px;">USERNAME</span>
							</div>
							<input type="text" class="form-control" id="username-field"
								placeholder="Entry Your Username">
							<div class="input-group-append">
								<span class="input-group-text" style="width: 96px;"> <a
									href="#">Forget Username</a>
								</span>
							</div>
						</div>
						<div class="input-group p-1">
							<div class="input-group-prepend">
								<span class="input-group-text" style="width: 96px;">PASSWORD</span>
							</div>
							<input type="password" class="form-control" id="password-field"
								placeholder="Entry Your Password">
							<div class="input-group-append">
								<span class="input-group-text" style="width: 96px;"> <a
									href="#">Forget Password</a>
								</span>
							</div>
						</div>
						<hr>
						<div class="input-group p-1">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<input type="checkbox" aria-label="Remember" value="on"
										id="signin-modal-label">
								</div>
							</div>
							<span class="input-group-text" for="signin-modal-label">REMEMBER
								ME</span>
						</div>
						<hr>
						<div class="form-group row p-0 m-0">
							<div class="col-6 p-1">
								<a href="#" class="btn btn-secondary btn-block">New User</a>
							</div>
							<div class="col-6 p-1">
								<button class="btn btn-primary btn-block">SIGN IN</button>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer bg-light">
					<button type="button" class="btn btn-secondary btn-block"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
</body>
</html>