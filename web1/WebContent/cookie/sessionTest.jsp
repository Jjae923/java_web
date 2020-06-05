<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 세션 확인
	String name;
	if(session.getAttribute("name")!=null){
		name = (String)session.getAttribute("name");
	}else{
		name = "세션 값 없음";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션 값 : <%=name %></h1>
	<h1>세션 테스트</h1>
	<button type="button" onclick="location.href='sessionSet.jsp'">세션 값 저장</button>
	<button type="button" onclick="location.href='sessionDel.jsp'">세션 값 삭제</button>
	<button type="button" onclick="location.href='sessionInval.jsp'">세션 값 초기화</button>
</body>
</html>
