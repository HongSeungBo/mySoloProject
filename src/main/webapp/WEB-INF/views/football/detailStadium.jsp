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
			<li class="stadium-detail">
				<div>
					<img src="/upload/${fn: replace(list.fsdfvo.saveDir, '\\', '/')}/${list.fsdfvo.uuid}_th_${list.fsdfvo.fileName}" alt="${list.fsdfvo.fileName}">
				</div>
				<div>
					<div>
						<span>구장이름</span><input type="text" value="${list.fsdvo.stadiumDetailName }" readonly="readonly">
						<span>구장크기</span><input type="text" value="${list.fsdvo.stadiumSize }" readonly="readonly">
						<select name="">
							<option>시간선택</option>
							<option value="09 ~ 11">09 ~ 11</option>
							<option value="11 ~ 13">11 ~ 13</option>
							<option value="13 ~ 15">13 ~ 15</option>
							<option value="15 ~ 17">15 ~ 17</option>
							<option value="17 ~ 19">17 ~ 19</option>
							<option value="19 ~ 21">19 ~ 21</option>
						</select>
					</div>
				</div>
				<div>
					<button type="button" data-fcode="${fdto.fvo.fcode }" data-stadiumdetailname="${list.fsdvo.stadiumDetailName }" data-num="1" class="Reser-Btn">예약</button>
					<button type="button" data-fcode="${fdto.fvo.fcode }" data-stadiumdetailname="${list.fsdvo.stadiumDetailName }" data-stadiumsize="${list.fsdvo.stadiumSize }" data-num="2" class="Update-Btn">수정</button>
					<button type="button" data-fcode="${fdto.fvo.fcode }" data-stadiumdetailname="${list.fsdvo.stadiumDetailName }" data-num="3" class="Delete-Btn">삭제</button>
				</div>
			</li>
		</c:forEach>
		<%-- <c:when test="">
			
		</c:when>
		<c:otherwise>
			
		</c:otherwise> --%>
	</ul>
	<div id="changeInfo" style="display: none;">
	</div>
<script type="text/javascript">
let fcodeVal = `<c:out value="${fdto.fvo.fcode}" />`;
</script>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript"	 src="/resources/js/football/AddStadiumDetail.js"></script>
<script type="text/javascript"	 src="/resources/js/football/DetailBtnEvent.js"></script>
</html>