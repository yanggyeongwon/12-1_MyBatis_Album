<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- insert.ab 요청  -->    
WEB-INF\album\AlbumInsertForm.jsp <br>

<h1>앨범 추가</h1>
<form action="insert.ab" method="post">
	<p>
		<label>노래제목</label>
		<input type="text" name="title" value="다이너마이트">
	</p>

	<p>
		<label>가수명</label>
		<input type="text" name="singer" value="방탄소년단">
	</p>
	
	<p>
		<label>가격</label>
		<input type="text" name="price" value="">
	</p>
	
	<p>
		<label>발매일</label>
		<input type="text" name="day" value="2020-9-1">
	</p>
	
	<p>
		<input type="submit" value="추가하기">
	</p>
</form>


