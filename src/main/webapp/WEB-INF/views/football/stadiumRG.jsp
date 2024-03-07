<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>풋볼 구장 등록</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

	<form action="/football/stadiumRG" method="post" enctype="multipart/form-data">
		<div class="img-con">
			<div id="imgBox"></div>
			<input type="file" name="fFile" id="fFile" style="display: none;">
			<button type="button" id="FIregBtn">첨부파일</button>
		</div>
		<div class="info">
			<span>구장코드</span><input type="text" name="fcode" placeholder="구장코드">
		</div>
		<div class="info">
			<span>구장이름</span><input type="text" name="stadiumName" placeholder="구장이름">
		</div>
		<div class="info">
			<span>시/도</span><input type="text" name="city" placeholder="지역">
		</div>
		<div class="info">
			<span>구/시</span><input type="text" name="districe" placeholder="도시이름">
		</div>
		<div class="info">
			<span>시작시간</span><input type="text" name="availableOpen" placeholder="시작시간">
		</div>
		<div class="info">
			<span>종료시간</span><input type="text" name="availableClose" placeholder="종료시간">
		</div>
		<div class="info">
			<span>구장개수</span><input type="text" name="totalStadiumNum" placeholder="총구장수">
		</div>
		<div class="info">
			<textarea rows="3" cols="30" name="description" placeholder="설명을 적어주세요."></textarea>
		</div>
		<div class="info">
			<span>유저아이디</span><input type="text" name="userName">
		</div>
		<!-- <div class="stadium-info">
			<div class="info">
				<div class="stadium-img"></div>
				<input type="text" name="">
			</div>
		</div> -->
		<div class="button-con">
			<button type="submit">등록</button>
			<a href="/"><button type="button">취소</button></a>
		</div>
	</form>
	
<jsp:include page="../common/footer.jsp"></jsp:include>
<script type="text/javascript" src="/resources/js/football/Register.js"></script>
</body>
</html>