<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN PAGE</title>
</head>
<body>
	<h1>LOGIN PAGE</h1>
	<hr>
	<br>
	<form action="/mem/login_auth" method="post">
		ID : <input type="text" name="id"><br><br>
		PASSWORD : <input type="password" name="password"><br><br>
		<button type="submit">LOGIN</button>	
	</form>
</body>
</html>