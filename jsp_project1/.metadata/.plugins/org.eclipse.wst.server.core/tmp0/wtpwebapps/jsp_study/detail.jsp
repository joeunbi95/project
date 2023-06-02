<%@page import="domain.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<style type="text/css">
table {
	text-align: left;
}
</style>
</head>
<body>
	<h1>상품 상세 페이지</h1>
	<hr>

	<table>
		<tr>
			<th>번호 : ${pvo.pno }</th>
		</tr>
		<tr>
			<th>상품명 : ${pvo.pname }</th>
		</tr>
		<tr>
			<th>가격 : ${pvo.price }</th>
		</tr>
		<tr>
			<th>등록일자 : ${pvo.regdate }</th>
		</tr>
		<tr>
			<th>상품설명 : ${pvo.madeby }</th>
		</tr>
	</table>
	<br>
	<a href="modify.pd?pno=${pvo.pno}"><button type="button">상품수정</button></a>
	<a href="remove.pd?pno=${pvo.pno}"><button type="button">상품삭제</button></a>
</body>
</html>