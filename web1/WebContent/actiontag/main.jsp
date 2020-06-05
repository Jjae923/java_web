<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%@include file="top.jsp" %> --%>
	<% pageContext.include("top.jsp"); %>
	<hr />
	<h1>여기는 메인입니다.</h1>
	<hr />
	<% pageContext.include("bottom.jsp"); %>
	<%-- <%@include file="bottom.jsp" %> --%>
</body>
</html>


