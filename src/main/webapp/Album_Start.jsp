<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String viewPage = request.getContextPath() + "/list.ab";
		System.out.println(viewPage);
		
		response.sendRedirect(viewPage);
	%>
</body>
</html>