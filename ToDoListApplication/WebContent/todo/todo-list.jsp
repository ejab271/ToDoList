<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>To Do List Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: skyblue;">
			<div>
				<a class="navbar-brand"> Todo App</a>
			</div>
			<c:if test="${todo != null}">
					<form action="list" method="get">
					 <a value = '${user.username}' id = "userId" name = "userId"><b>Username:${user.username} ID:${user.id}</b></a>
				</c:if>

			<ul class="navbar-nav">
				<li><a href="list?userId=<c:out value='${user.username}' />"
					class="nav-link">List of Todos</a></li>
			</ul>
		
	 <a value = '${user.username}' id = "userId" name = "userId"><b>Username:${user.username} ID:${user.id}</b></a>
	 
        <br><br>
			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Todos</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-primary">Add a
					Todo</a>
					
					<a href="list?userId=<c:out value='${user.username}' />" class="btn btn-primary">Refresh
					Todo List</a>
			</div>
			<br>
		
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Last Updated</th>
						<th>Description </th>
						<th>Target Date</th>
						<th>Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="todo" items="${listTodo}">

						<tr>
							<td><c:out value="${todo.title}" /></td>
							<td><c:out value="${todo.ts}" /></td>
							<td ><c:out value="${todo.description}" /></td>
							<td><c:out value="${todo.targetDate}" /></td>
							<td ><c:out value="${todo.status}" /></td>
							

							<td><a href="edit?id=<c:out value='${todo.id}' />"class="btn btn-success">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=<c:out value='${todo.id}' /> "class="btn btn-warning"">Delete</a></td>

					 
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>

</html>
