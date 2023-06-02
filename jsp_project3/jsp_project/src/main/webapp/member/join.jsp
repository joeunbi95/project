<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN PAGE</title>
<style type="text/css">
	input {
		width: 200px;
		height: 20px;
		margin-left: 10px;
	}
	form {
		font-weight: bold;
	}
</style>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<hr>
	<br>
	<form action="/mem/register" method="post">
		아이디 : <input type="text" name="id" placeholder="영문4자이상"><br><br>
		비밀번호 : <input type="password" name="password" placeholder="숫자+영문+특수문자 8자이상"><br><br>
		이메일 : <input type="email" name="email" placeholder="EMAIL"><br><br>
		나이 : <input type="text" name="age" placeholder="AGE"><br><br>
		
		<button type="submit">가입완료</button>
	</form>
	<br>
	<hr>
	
</body>
</html>