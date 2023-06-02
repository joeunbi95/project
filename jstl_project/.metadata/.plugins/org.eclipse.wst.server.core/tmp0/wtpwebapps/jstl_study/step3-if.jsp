<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL if</title>
</head>
<body>
	<%-- JSTL if 조건 --%>
	<c:if test="true">
	
	<%-- test 조건이 true일경우에만 실행 --%>
	true 이므로 실행되어야 함.
	</c:if>
	
	<%-- Query String 방식 --%>
	<a href="step3-if.jsp?age=13&nick=apple">step3-if 다시 호출</a>
	<br><br>
	이름 : ${param.nick}<br>
	나이 : ${param.age }<br>
	<br>
	<%-- 나이가 5보다 크면 출력 --%>
	<c:if test="${param.age > 5 && param.nick=='apple'}">
	나이가 5보다 크고 닉네임이 apple인경우 출력되는 글자<br>
	이름 : ${param.nick}, 나이 : ${param.age }살<br>
	</c:if>
	<br>
	<hr>
	
	<%-- 나이가 5보다 크면 출력 --%>
	<form method="get">		
		나이 : <input type="text" name="age2">
		<input type="submit" value="전송">
	</form>
	
	<c:if test="${param.age2 > 5 }"><br>
	나이 : ${param.age2 }살<br>
	</c:if>
	
	
	
		
	
	
	
	
</body>
</html>