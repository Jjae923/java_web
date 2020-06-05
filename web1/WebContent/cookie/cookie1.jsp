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
		// 쿠키 저장하기
		Cookie cookie = new Cookie("name","John");
		cookie.setMaxAge(600);
		response.addCookie(cookie);
		
		response.addCookie(new Cookie("gender","Male"));
		response.addCookie(new Cookie("age","30"));
	%>
	<h3>쿠키 데이터가 저장되었습니다.</h3>
	<a href="getCookie1.jsp">확인</a>
</body>
</html>
