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
	<div class="imageFile">
		<img src="/upload/${fn: replace(fdto.fbsfvo.saveDir, '\\', '/')}/${fdto.fbsfvo.uuid}_th_${fdto.fbsfvo.fileName}" alt="${fdto.fbsfvo.fileName}">
	</div>
	<div class="info">
		<span>구장이름</span><input type="text" name="stadiumName" value="${fdto.fbvo.stadiumName }" readonly="readonly">
	</div>
	<div class="info">
		<span>시/도</span><input type="text" name="city" value="${fdto.fbvo.city }" readonly="readonly">
	</div>
	<div class="info">
		<span>구/시</span><input type="text" name="districe" value="${fdto.fbvo.districe }" readonly="readonly">
	</div>
	<div class="info">
		<span>시작시간</span><input type="text" name="availableOpen" value="${fdto.fbvo.availableOpen }" readonly="readonly">
	</div>
	<div class="info">
		<span>종료시간</span><input type="text" name="availableClose" value="${fdto.fbvo.availableClose }" readonly="readonly">
	</div>
	<div class="info">
		<span>구장개수</span><input type="text" name="totalStadiumNum" value="${fdto.fbvo.totalStadiumNum }" readonly="readonly">
	</div>
	<div class="info">
		<textarea rows="3" cols="30" name="description" readonly="readonly">${fdto.fbvo.description }</textarea>
	</div>
</body>
</html>