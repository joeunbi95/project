<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<h1>Index Page</h1>
	<hr>
	<br>
	
	<c:if test="${ses.id  ne null}">
		${ses.id }님이 login 하였습니다. <br>
		계정생성일 : ${ses.reg_date }<br>
		마지막 접속 : ${ses.last_login }<br><br>
		<a href="/mem/modify"><button type="button">회원정보수정</button></a>		
		<a href="/brd/register"><button type="button">게시글 작성</button></a>
		<a href="/brd/page"><button type="button">게시판리스트</button></a>
		<br><br>
		
		<a href="/mem/logout"><button type="button">로그아웃</button></a>
	</c:if>
	<c:if test="${ses.id eq null }">	
	<a href="/mem/login"><button type="button">로그인</button></a>
	<a href="/mem/join"><button type="button" >회원가입</button></a>
	<a href="/mem/list"><button type="button">회원리스트</button> </a>
	<br>
	</c:if>
	<br>
	<hr>	
</body>
<script type="text/javascript">
	const msg_login = `<c:out value="${msg_login}"/>`;
	console.log(msg_login);
	if(msg_login === '0'){
		alert('로그인 정보가 올바르지않습니다.');
	}
</script>
</html>