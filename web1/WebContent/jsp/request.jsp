<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSP주석 --%>
<%-- 내장객체 : request --%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>userid : <%=request.getParameter("userid") %></h2>
	<h2>password : <%=request.getParameter("password") %></h2>
</body>
</html>
