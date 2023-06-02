<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트 페이지</title>
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
	<h1>상품 리스트 페이지</h1>
	<hr>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>상품명 [CLICK]</th>
				<th>등록날짜</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${list }" var="pvo" varStatus="">
					<tr>
						<td>${pvo.pno}</td>
						<th><a href="detail.pd?pno=${pvo.pno}">${pvo.pname}</a></th>
						<td>${pvo.regdate}</td>
					</tr>
				</c:forEach>
		</tbody>
	</table>

	<a href="register.pd"><button type="button">상품등록</button></a>
	<a href="index.pd"><button type="button">처음화면</button></a>
</body>
</html>