<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.PersonVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
	width: 500px;
	text-align: center;
}

thead {
	background-color: gray;
	color: white;
}

tbody {
	background-color: silver;
	color: black;
}
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		//PersonVO 객체를 이용하여 list에 여러명을 추가 (5명)
		//list를 request 객체에 담아 jsp로 전송
		ArrayList<PersonVO> list = new ArrayList<>();
		list.add(new PersonVO("홍길동",40));
		list.add(new PersonVO("홍길순",35));
		list.add(new PersonVO("홍길자",5));
		list.add(new PersonVO("홍기철",17));
		list.add(new PersonVO("홍기자",2));
		request.setAttribute("p", list);
	%>

	<%-- 테이블을 생성하여 list를 출력 --%>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>연령대</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.p}" var="li" varStatus="ord">
				<tr>
					<th>${ord.count }</th>
					<td>${li.name }</td>
					<td>${li.age }</td>
					<td>
						<%-- ${li.age >=20 ? "성인" : "미성년"} --%>
						<c:choose>
							<c:when test="${li.age >= 20 }">성인</c:when>
							<c:when test="${li.age >= 15 }">청소년</c:when>
							<c:when test="${li.age <= 5 }">어린이</c:when>
							<c:otherwise>유아</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>