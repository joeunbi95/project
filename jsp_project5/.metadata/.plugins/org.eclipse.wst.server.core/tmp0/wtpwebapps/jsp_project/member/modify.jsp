<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정 페이지</title>
	<style type="text/css">
		body{
			text-align: center;
		}
		
		div{
		border: 1px solid black;
		width: 300px;
		height: 300px;
		margin: auto;
		padding-top: 40px;
		border-radius: 10px;
	}
	</style>
</head>
<body>
	<h1>회원정보수정 페이지</h1>
	<form action="/mem/edit" method="post">
		<div>
			<input type="hidden" name="id" value="${ses.id}">
			<%-- readonly="readonly" 읽기 전용--%> 
			아이디 : <input type="text" name="id" disabled="disabled" value="${ses.id}"><br><br>
			비밀번호 : <input type="text" name="password" value="${ses.password }"><br><br>
			이메일 : <input type="email" name="email" value="${ses.email }"><br><br>
			나이 : <input type="text" name="age" value="${ses.age }"><br><br>
			<input type="hidden" name="reg_date" value="${ses.reg_date }"><br>
			<input type="hidden" name="last_login" value="${ses.last_login}"><br>
			<button type="submit">수정완료</button>
			<a href="/mem/remove"><button type="button" onclick="btn()">회원탈퇴</button></a>
		</div>
	</form>
</body>
<script type="text/javascript">
	function btn() {
		alert('회원탈퇴가 완료되었습니다.');
	}
</script>
</html>