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
앨범 리스트<br>
레코드 갯수 : ${totalCount }
<script>

	function goUpdate(num){
		location.href="update.ab?num="+num;
	}
</script>
<form action="list.ab" method="post">
	<select name="whatColumn">
		<option value="all">전체검색
		<option value="title">노래검색
		<option value="singer">가수검색
	</select>
	<input type="text" name="keyword" value="아이유">
	<input type="submit" value="검색">
</form>
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
			<td><a href="delete.ab?num=${album.num }">삭제</a></td>
			<td><a href="update.ab?num=${album.num }">수정</a></td>
			<td><input type="button" value="수정" onclick="goUpdate(${album.num})"/>
		</tr>
	</c:forEach>
	
	</table>
	${pageInfo.pagingHtml }
	<a href="insert.ab">삽입</a>		

</body>
</html>