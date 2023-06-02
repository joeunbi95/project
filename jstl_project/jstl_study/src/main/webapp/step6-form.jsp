<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- step6-form.jsp, step6-action.jsp
		 form 태그안에 check box 생성
		 주문자 : 이름
		 체크박스의 내용물을 선택하여 action으로 전송
		 
		 action에서 내용물을 선택하여 action으로 전송
	--%>
	
	<%-- get방식 : 쿼리스트링을 달고 URL 상에서 이동하는 방식(기본)--%>
	<%-- post방식 : 데이터를 숨겨서 가는 방식 --%>
	
	
	<form action="step6-action.jsp" method="post">
		주문자 : <input type="text" name="name"><br>
		<input type="checkbox" name="fruit" value="사과">사과<br>
		<input type="checkbox" name="fruit" value="오랜지">오렌지<br>
		<input type="checkbox" name="fruit" value="포도">포도<br>
		<input type="checkbox" name="fruit" value="바나나">바나나<br>
		<input type="checkbox" name="fruit" value="귤">귤<br>
		<input type="submit" value="전송">
	</form>
</body>
</html>