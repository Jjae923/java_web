<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 내장객체 : session → http 프로토콜의 stateless 보완 기술
	 톰캣의 세션 유지시간 : 30분(기본값)
--%>
<% 
	// 세션 유효 시간 변경 : 10초
	session.setMaxInactiveInterval(10);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 테스트</h2>
	<p>isNew() : <%=session.isNew()%></p>
	<p>생성시간 : <%=session.getCreationTime()%></p>
	<p>최종접속시간 : <%=session.getLastAccessedTime()%></p>
	<p>세션ID : <%=session.getId()%></p>
</body>
</html>
