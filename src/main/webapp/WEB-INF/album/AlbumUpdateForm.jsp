<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
	.err{
	color:red}
</style>
<h1>앨범 추가</h1>
업데이트 폼
<form:form commandName="ab" action="update.ab" method="post">
<input type="hidden" name="num" value="${ ab.num }">
	<p>
		<label>노래제목</label>
		<input type="text" name="title" value="${ab.title }">
		<form:errors cssClass="err" path="title"/>
	</p>

	<p>
		<label>가수명</label>
		<input type="text" name="singer" value="${ab.singer }">
		<form:errors cssClass="err" path="singer"/>
	</p>
	
	<p>
		<label>가격</label>
		<input type="text" name="price" value="${ab.price }">
		<form:errors cssClass="err" path="price"/>
	</p>
	
	<p>
		<label>발매일</label>
		<input type="text" name="day" value="${ab.day }">
		<form:errors cssClass="err" path="day"/>
	</p>
	
	<p>
		<input type="submit" value="추가하기">
	</p>
</form:form>
</body>
</html>