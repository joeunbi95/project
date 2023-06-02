<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 페이지</title>
</head>
<body>
	<h1>게시글 수정 페이지</h1>
	<hr>
	<br>
	<form action="/brd/edit" enctype="multipart/form-data" method="post">
		번호 : <input type="text" name="bno" value="${bvo.bno }" readonly="readonly"><br><br>
		제목 : <input type="text" name="title" value="${bvo.title }"><br><br>
		작성자 : <input type="text" name="writer" value="${bvo.writer }"><br><br>
		내용 : <textarea rows="3" cols="30" name="content">${bvo.content }</textarea><br><br>
		작성일 : <input type="text" name="reg_date" value="${bvo.reg_date }" readonly="readonly"><br><br>
		<button type="submit">수정완료</button>
		<a href="/brd/remove?bno=${bvo.bno }"><button type="button">게시물삭제</button></a>
	</form>
</body>
</html>