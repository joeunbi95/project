<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 페이지</title>
</head>
<body>
	<h1>상품 수정 페이지</h1>
	<hr>
	<form action="edit.pd" method="post">
		<input type="hidden" name="pno" value="${pvo.pno}"> 
		번호 : <input type="text" name="pno" value="${pvo.pno}" disabled="disabled"><br>
		상품명 : <input type="text" name="pname" value="${pvo.pname}"> <br>
		가격	: <input type="text" name="price" value="${pvo.price}"> <br>
		등록일자 : <input type="text" name="regdate" value="${pvo.regdate }" disabled="disabled"> <br>
		상품설명 : <input type="text" name="madeby" value="${pvo.madeby}"><br>
		<button type="submit">수정완료</button>
	</form>
	
	<br>


</body>
</html>