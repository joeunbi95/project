<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL param 연습 3</title>
</head>
<body>
	<%-- 스클립트릿 방식에서는 넘어오는 paramter값이 문자열로 인식 
		 age+1의 값을 전달하면 201 나이 뒤에 1이 추가되는 형태로 전송--%>
	1. 스클립틀릿 방식으로 파라미터를 전달받음<br>
	<%=request.getParameter("nick") %><br>
	<%=request.getParameter("age")+1 %><br>
	<br><br>
	
	<hr>
	
	<%-- EL 방식은 내부적으로 형변환(Integer.parseInt())
		이 이루어져 연산이 가능 20+1 로 인신되어 전송 --%>
	2. EL 방식으로 파라미터를 전달받음 <br>
	닉네임 : ${param.nick} <br>
	나이 : ${param.age} 살 <br>
	<br><br>
	
	<hr>
	<form action="step2-4.jsp">
		<input type="checkbox" name="food" value="삼겹살">삼겹살 <br>
		<input type="checkbox" name="food" value="목살">목살 <br>
		<input type="submit" value="전송">
	</form>
</body>
</html>