<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트 페이지</title>
<style type="text/css">
body{
	text-align: center;
}
table {	
	width: 700px;
	height: 200px;
	margin: auto;
	margin-top: 50px;
}
thead {
	background-color: gray;
	color: white;
	height: 50px;
}

tbody {
	background-color: silver;
	color: white;
}

button {
	margin-top: 20px;
	
}

a {
	text-decoration: none;
	color: black;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>리스트 페이지</h1>
	<hr>
	<br>
	
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="bvo">
				<tr>
					<td>${bvo.bno }</td>
					<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>
					<td>${bvo.writer }</td>
					<td>${bvo.reg_date }</td>
					<td>${bvo.read_count }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<!-- 페이지네이션 위치 -->
	<!-- 컨트롤러에서 page 정보를 싣고 와야함.  -->
	<!-- startpage~endpage까지 숫자 반복 foreach -->
	
	
	<!-- 이전페이지 -->	
	<c:if test="${pgh.prev }">
		<a href="/brd/page?pageNo=${pgh.startPage-1 }&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">
			◁ </a>
	</c:if>
	<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
		<a href="/brd/page?pageNo=${i }&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">${i } | </a>
	</c:forEach>
	
	
	<!-- 다음페이지 -->	
	<c:if test="${pgh.next }">
		<a href="/brd/page?pageNo=${pgh.endPage+1 }&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">
			▷ </a>
	</c:if>
	<br>
	
	
	<!-- 검색 라인 -->
	<form action="/brd/page" method="post">
		<div>
			<c:set value="${pgh.pgvo.type }" var="typed"></c:set>
			<select name="type">
			 <!-- selected : 현재 내가 선택한 값 -->
				<option ${typed == null ? 'selected':'' }>Choose...</option>
				<option value="t" ${typed eq 't' ? 'selected':'' }>title</option>
				<option value="c" ${typed eq 'c' ? 'selected':'' }>content</option>
				<option value="w" ${typed eq 'w' ? 'selected':'' }>writer</option>
				<option value="tc" ${typed eq 'tc' ? 'selected':'' }>title or content</option>
				<option value="tw" ${typed eq 'tw' ? 'selected':'' }>title or writer</option>
				<option value="cw" ${typed eq 'cw' ? 'selected':'' }>content or writer</option>
			</select>		
			<input type="text" name="keyword" placeholder="search">
			<input type="hidden" name="pageNo" value="${pgh.pgvo.pageNo }">
			<input type="hidden" name="qty" value="${pgh.pgvo.qty }">
			<button type="submit">search</button>
		</div>
	</form>
		<a href="/"><button>처음화면</button></a>
	<br>
	<br>
	<hr>
	
	
</body>
</html>