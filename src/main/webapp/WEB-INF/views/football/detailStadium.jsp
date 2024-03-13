<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="imageFile">
		<img src="/upload/${fn: replace(fdto.fsfvo.saveDir, '\\', '/')}/${fdto.fsfvo.uuid}_th_${fdto.fsfvo.fileName}" alt="${fdto.fsfvo.fileName}">
	</div>
	<input type="text" name="fcode" value="${fdto.fvo.fcode }" style="display: none">
	<div class="info">
		<span>구장이름</span><input type="text" name="stadiumName" value="${fdto.fvo.stadiumName }" readonly="readonly">
	</div>
	<div class="info">
		<span>시/도</span><input type="text" name="city" value="${fdto.fvo.city }" readonly="readonly">
	</div>
	<div class="info">
		<span>구/시</span><input type="text" name="districe" value="${fdto.fvo.districe }" readonly="readonly">
	</div>
	<div class="info">
		<span>시작시간</span><input type="text" name="availableOpen" value="${fdto.fvo.availableOpen }" readonly="readonly">
	</div>
	<div class="info">
		<span>종료시간</span><input type="text" name="availableClose" value="${fdto.fvo.availableClose }" readonly="readonly">
	</div>
	<div class="info">
		<span>구장개수</span><input type="text" name="totalStadiumNum" value="${fdto.fvo.totalStadiumNum }" readonly="readonly">
	</div>
	<div class="info">
		<textarea rows="3" cols="30" name="description" readonly="readonly">${fdto.fvo.description }</textarea>
	</div>
	
	<button type="button" id="AddST">구장추가</button>
	<div class="add-zone">
		<div id="hiddenBox" style="display: none;">
			<div id="imageBox"></div>
			<button type="button" id="FDIregBtn">첨부파일</button>
			<input type="file" name="fDetailFile" id="fDetailFile" style="display: none;">
			<input type="text" name="fcode" id="fcode" value="${fdto.fvo.fcode }" readonly="readonly">
			<input type="text" name="stadiumDetailName" id="stadiumDetailName" placeholder="A구장">
			<input type="text" name="stadiumSize" id="stadiumSize" placeholder="사이즈">
			<button type="button" id="addBtn">추가</button>
			<button type="button" id="cancelBtn">취소</button>
		</div>
	</div>
	<ul id="AddSTZone">
		<c:forEach var="list" items="${list }">
			<li>
				<div>
					<img src="/upload/${fn: replace(list.fsdfvo.saveDir, '\\', '/')}/${list.fsdfvo.uuid}_th_${list.fsdfvo.fileName}" alt="${list.fsdfvo.fileName}">
				</div>
				<div>
					<div>구장이름 : ${list.fsdvo.stadiumDetailName }</div>
					<div>구장크기 : ${list.fsdvo.stadiumSize }</div>
				</div>
			</li>
		</c:forEach>
		<%-- <c:when test="">
			
		</c:when>
		<c:otherwise>
			
		</c:otherwise> --%>
	</ul>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript"	 src="/resources/js/football/AddStadiumDetail.js"></script>
</html>