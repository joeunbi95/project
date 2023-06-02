<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 페이지</title>
<style type="text/css">
	h1{
		text-align: center;
	}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<h1>게시글 상세 페이지</h1>
	<hr>
	<br>
	<div>
		<img alt="없음" src="/_fileUpload/${bvo.image_file }">
	</div>	
	<div>	
		번호 : ${bvo.bno } <br><br>
		제목 : ${bvo.title } <br><br>
		작성자 : ${bvo.writer } <br><br>
		내용 : ${bvo.content}<br><br>
		작성날짜 : ${bvo.reg_date } <br><br>
	</div>
	<hr>
	<br>	
	<a href="/brd/modify?bno=${bvo.bno }"><button type="button" id="btn">게시글 수정</button></a>
	<a href="/brd/page"><button type="button">처음화면</button></a>
	<br>
	<br>
	<hr>
	<br>
	<div>
	<h4>댓글 리스트</h4>
	<%-- 댓글 작성 라인 --%>
	<input type="text" id="cmtWriter" value="${ses.id }" readonly="readonly"><br><br>
	<input type="text" id="cmtText" placeholder="Add Comment">
	<button type="button" id="cmtAddBtn">댓글등록</button>
	</div><br>	
	
	<%-- 댓글 표시 라인 --%>
	<div class="accordion" id="accordionExample">
		<div class="accordion-item">
			<h2 class="accordion-header" id="headingOne">
				<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
					cno, writer
				</button>
			</h2>
			<div id="collapseOne" class="accordion-collapse collapse show"
				aria-labelledby="headingOne" data-bs-parent="#accordionExample">
				<div class="accordion-body">
					contetn, reg_date
				</div>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
<script type="text/javascript">
const bnoVal = `<c:out value ="${bvo.bno}" />`;
</script>
<script src="/resources/board_detail.js"></script>
<script type="text/javascript">
printCommentList(bnoVal);
</script>
</html>