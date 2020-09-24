<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- insert.ab 요청  -->    
WEB-INF\album\AlbumInsertForm.jsp <br>

<style>
	.err{
	color:red}
</style>
<h1>앨범 추가</h1>
앨범 폼
<form:form commandName="albumBean" action="insert.ab" method="post">
	<p>
		<label>노래제목</label>
		<input type="text" name="title" value="${albumDao.title }">
		<form:errors cssClass="err" path="title"/>
	</p>

	<p>
		<label>가수명</label>
		<input type="text" name="singer" value="${albumDao.singer }">
		<form:errors cssClass="err" path="singer"/>
	</p>
	
	<p>
		<label>가격</label>
		<input type="text" name="price" value="${albumDao.price }">
		<form:errors cssClass="err" path="price"/>
	</p>
	
	<p>
		<label>발매일</label>
		<input type="text" name="day" value="${albumDao.day }">
		<form:errors cssClass="err" path="day"/>
	</p>
	
	<p>
		<input type="submit" value="추가하기">
	</p>
</form:form>


