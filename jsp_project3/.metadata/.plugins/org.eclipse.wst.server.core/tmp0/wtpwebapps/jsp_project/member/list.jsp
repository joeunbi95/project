<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list Page</title>
<style type="text/css">
body{
	text-align: center;
}
table {	
	width: 700px;
	height: 200px;
	margin: auto;
	margin-top: 50px;
}
thead {
	background-color: gray;
	color: white;
	height: 50px;
}

tbody {
	background-color: silver;
	color: white;
}

button {
	margin-top: 20px;
	
}

a {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<h1>list Page</h1>
	<hr>
	<br>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>EMAIL</th>
				<th>age</th>
				<th>reg_date</th>
				<th>last_login</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="mvo" varStatus="">
				<tr>
					<td>${mvo.id }</td>
					<td>${mvo.email }</td>
					<td>${mvo.age }</td>
					<td>${mvo.reg_date }</td>
					<td>${mvo.last_login }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>