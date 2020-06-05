<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 내장객체 : application → 서버 측 정보나 서버 측 자원에 대해 접근 가능 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>웹 어플리케이션 URL 경로명 : <%=application.getContextPath() %></h3>
	<h3>현재 jsp 파일 경로명 : <%=application.getRealPath("application.jsp") %></h3>
</body>
</html>