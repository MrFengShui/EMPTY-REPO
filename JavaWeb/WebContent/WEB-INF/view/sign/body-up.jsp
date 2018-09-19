<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div
		class="row bg-light d-flex justify-content-center align-items-center"
		id="signup-middle">
		<form action="#" method="post" class="card" style="max-width: 640px;">
			<div class="card-header bg-dark display-4">SIGN UP</div>
			<div class="card-body">
				<div class="input-group p-1">
					<div class="input-group-prepend">
						<span class="input-group-text d-flex justify-content-center"
							style="width: 96px;">PERSON</span>
					</div>
					<input type="text" class="form-control" aria-label="First Name"
						placeholder="First Name"> <input type="text"
						class="form-control" aria-label="Last Name"
						placeholder="Last Name">
				</div>
				<div class="input-group p-1">
					<div class="input-group-prepend">
						<span class="input-group-text d-flex justify-content-center"
							style="width: 96px;">DATE OF BIRTH</span>
					</div>
					<input type="text" class="form-control" placeholder="2018">
					<select class="custom-select" style="height: 34px;">
						<option disabled="true" selected="true">Choose...</option>
						<option>January</option>
						<option>February</option>
						<option>March</option>
						<option>April</option>
						<option>May</option>
						<option>June</option>
						<option>July</option>
						<option>Augest</option>
						<option>September</option>
						<option>October</option>
						<option>November</option>
						<option>December</option>
					</select> <input type="text" class="form-control" placeholder="3">
				</div>
				<div class="input-group p-1">
					<div class="input-group-prepend">
						<span class="input-group-text d-flex justify-content-center"
							style="width: 96px;">ADDRESS</span>
					</div>
					<input type="text" class="form-control" aria-label="Address"
						placeholder="NW 1234 Main St.">
				</div>
				<div class="input-group p-1">
					<div class="input-group-prepend">
						<span class="input-group-text d-flex justify-content-center"
							style="width: 96px;">ADDRESS 2</span>
					</div>
					<input type="text" class="form-control" placeholder="Main Apt. #18"
						aria-label="Address 2">
				</div>
				<div class="input-group p-1">
					<div class="input-group-prepend">
						<span class="input-group-text d-flex justify-content-center"
							style="width: 96px;">LOCATION</span>
					</div>
					<input type="text" class="form-control" placeholder="New York">
					<select class="custom-select" style="height: 34px;">
						<option disabled="true" selected="true">Choose...</option>
						<option>HUBEI</option>
						<option>HUNAN</option>
					</select> <input type="text" class="form-control" placeholder="97330">
				</div>
				<div class="input-group p-1">
					<div class="input-group-prepend">
						<span class="input-group-text d-flex justify-content-center"
							style="width: 96px;">CONTACT</span>
					</div>
					<input type="email" class="form-control"
						placeholder="Email Address">
					<div class="input-group-append">
						<div class="dropdown">
							<span
								class="input-group-text d-flex justify-content-center dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false" style="width: auto; height: 34px;">@gmail.com</span>
							<ul class="dropdown-menu">
								<li class="dropdown-item"><a href="#">@gmail.com</a></li>
								<li class="dropdown-item"><a href="#">@outlook.com</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="input-group p-1">
					<div class="input-group-prepend">
						<span class="input-group-text d-flex justify-content-center"
							style="width: 96px;">PHONE</span>
						<div class="dropdown">
							<span
								class="input-group-text d-flex justify-content-center dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false" style="width: auto; height: 34px;">+86</span>
							<ul class="dropdown-menu">
								<li class="dropdown-item"><a href="#">China(+86)</a></li>
								<li class="dropdown-item"><a href="#">United States(+1)</a>
								</li>
							</ul>
						</div>
					</div>
					<input type="email" class="form-control" placeholder="Phone Number">
				</div>
				<hr class="bg-light">
				<div class="input-group p-1">
					<div class="input-group-prepend">
						<span class="input-group-text d-flex justify-content-center"
							style="width: 96px;">USERNAME</span>
					</div>
					<input type="text" class="form-control" placeholder="Username">
				</div>
				<div class="input-group p-1">
					<div class="input-group-prepend">
						<span class="input-group-text d-flex justify-content-center"
							style="width: 96px;">NICKNAME</span>
					</div>
					<input type="text" class="form-control" placeholder="Nickname">
				</div>
				<div class="input-group p-1">
					<div class="input-group-prepend">
						<span class="input-group-text d-flex justify-content-center"
							style="width: 96px;">PASSWORD</span>
					</div>
					<input type="password" class="form-control" placeholder="Password">
				</div>
				<div class="input-group p-1">
					<div class="input-group-prepend">
						<span class="input-group-text d-flex justify-content-center"
							style="width: 96px;">RE-PASSWORD</span>
					</div>
					<input type="password" class="form-control"
						placeholder="Password Confirmed">
				</div>
				<hr class="bg-light">
				<div class="input-group p-1">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<input type="checkbox" aria-label="Agreement" id="agree-label"
								value="on">
						</div>
					</div>
					<span class="input-group-text" for="agree-label"> I have
						read&nbsp; <a href="#" data-toggle="modal"
						data-target="#agree-modal">agreement</a>&nbsp;and agree all.
					</span>
				</div>
			</div>
			<div class="card-footer bg-light">
				<div class="input-group p-1">
					<div class="input-group-prepend w-50 p-1">
						<a href="#" class="btn btn-primary btn-block">SIGN IN</a>
					</div>
					<div class="input-group-append w-50 p-1">
						<input type="submit" class="btn btn-secondary btn-block"
							value="SIGN UP">
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>