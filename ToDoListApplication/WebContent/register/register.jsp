<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To Do List Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container">

		<h2>User Register Form</h2>
		<div class="col-md-6 col-md-offset-3">

			<form action="<%=request.getContextPath()%>/register" method="post">
			
			<div class="alert alert-success center" role="alert">
				<p>${NOTIFICATION}</p>
			</div>

				<div class="form-group">
					<label for="uname">First Name:</label> <input type="text"
						class="form-control" id="uname" placeholder="First Name"
						name="firstName" required>
				</div>

				<div class="form-group">
					<label for="uname">Last Name:</label> <input type="text"
						class="form-control" id="uname" placeholder="last Name"
						name="lastName" required>
				</div>

		<!-- 		<div class="form-group">
					<label for="uname">Team:</label> <select class="form-control"
						name="team" id="uname">
						<option></option>
						<option value="Test">Test</option>
						<option value="Business">Business</option>
						<option value="Development">Development</option>
						<option value="Finance">Finance</option>
						<option value="Management">Management</option>
					</select>
				</div> -->

				<div class="form-group">
					<label for="uname">User Name:</label> <input type="text"
						class="form-control" id="username" placeholder="User Name"
						name="username" required>
				</div>

				<div class="form-group">
					<label for="uname">Password:</label> <input type="password"
						class="form-control" id="password" placeholder="Password"
						name="password" required>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>

			</form>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>