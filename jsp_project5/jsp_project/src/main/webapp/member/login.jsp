<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN PAGE</title>
<style type="text/css">
	body{
		text-align: center;
	}
	div{
		border: 1px solid black;
		width: 300px;
		height: 150px;
		margin: auto;
		padding-top: 40px;
		border-radius: 10px;
	}
</style>
</head>
<body>
	<h1>LOGIN</h1>
	<hr>
	<br>
	<form action="/mem/login_auth" method="post">
		<div>
			ID : <input type="text" name="id"><br><br>
			PW : <input type="password" name="password"><br><br>
		<button type="submit">LOGIN</button>	
		</div>
	</form>
</body>
</html>