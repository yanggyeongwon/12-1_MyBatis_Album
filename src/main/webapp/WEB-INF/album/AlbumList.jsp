<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
앨범 리스트
	<table border="1">
		<tr>
			<td>번호</td>
			<td>노래제목</td>
			<td>가수명</td>
			<td>가격</td>
			<td>출간일</td>
			<td>삭제</td>
			<td>수정</td>
		</tr>
	<c:forEach var="album" items="${lists }">
		<tr>
			<td>${album.num }</td>
			<td>${album.title }</td>
			<td>${album.singer }</td>
			<td>${album.price }</td>
			<td>${album.day }</td>
			<td><a href="#">삭제</a></td>
			<td><a href="#">수정</a></td>
		</tr>
	</c:forEach>
	
	</table>
	<a href="#">삽입</a>		
</body>
</html>