<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 내장객체 : pageContext → 다른 내장 객체에 접근할 수 있는 객체 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 포함할 페이지
		pageContext.include("header.jsp");
	%>
	<h2>pageContext 페이지</h2>
	<%
		// 포함할 페이지
		pageContext.include("footer.jsp");
	%>
</body>
</html>
