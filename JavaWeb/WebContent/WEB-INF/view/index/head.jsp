<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="row bg-dark p-1">
		<div
			class="m-0 p-0 align-items-center col-auto d-flex justify-content-center"
			style="max-width: 76px;">
			<a href="#"> <img alt="logo"
				src="http://www.timesofarticle.com/wp-content/uploads/2017/10/jsp.png"
				class="img-flush" height="38" width="61.11">
			</a>
		</div>
		<div
			class="m-0 p-0 col d-flex justify-content-center align-items-center">
			<form action="#" method="post" class="input-group w-75">
				<input type="search" class="form-control" placeholder="">
				<div class="input-group-append">
					<button class="btn btn-primary">SEARCH</button>
				</div>
			</form>
		</div>
		<div class="row m-0 p-0 col-auto">
			<div class="dropdown dropleft">
				<a href="#" id="profile-drop-btn" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"
					class="dropdown-toggle-split"> <img alt="logo"
					src="http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png"
					class="img-flush img-fluid" width="48" height="48"> <span
					class="sr-only">Toggle Dropdown</span>
				</a>
				<ul class="dropdown-menu">
					<li class="dropdown-item p-1" style="display: none;">
						<div class="card">
							<img class="card-img-top"
								src="http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png"
								alt="">
							<ul class="list-group list-group-flush">
								<li class="list-group-item">NICKNAME: Anonymous</li>
								<li class="list-group-item">EMAIL: anonymous@gmail.com</li>
								<li class="list-group-item">PHONE: +1(514)745-8987</li>
							</ul>
						</div>
					</li>
					<li class="dropdown-item p-1">
						<button class="btn btn-secondary btn-block btn-sm"
							data-target="#signin-modal" data-toggle="modal">SIGN IN</button>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>