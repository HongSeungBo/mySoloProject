<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구장선택</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="fot-con">
		<h2>풋살장</h2>
		<c:forEach var="list" items="${list }">
			<div>
				<div>
					<img src="/upload/${fn: replace(list.fsfvo.saveDir, '\\', '/')}/${list.fsfvo.uuid}_th_${list.fsfvo.fileName}" alt="${list.fsfvo.fileName}">
				</div>
				<div>
					<%-- <input type="text" value="${list.fbvo.fcode }" readonly="readonly"> --%>
					<div>
							<p><a href="/football/detailStadium?fcode=${list.fvo.fcode }">${list.fvo.stadiumName }</a></p>
							<p><a href="/football/detailStadium?fcode=${list.fvo.fcode }">${list.fvo.city }</a></p>
							<p><a href="/football/detailStadium?fcode=${list.fvo.fcode }">${list.fvo.availableOpen }</a></p>
							<p><a href="/football/detailStadium?fcode=${list.fvo.fcode }">${list.fvo.availableClose }</a></p>
							<p><a href="/football/detailStadium?fcode=${list.fvo.fcode }">${list.fvo.totalStadiumNum }</a></p>
							<p>${list.fvo.description }</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="soc-con">
		<h2>축구장</h2>
	</div>
	<!-- <a href="#"><button type="button">수정</button></a> -->
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>