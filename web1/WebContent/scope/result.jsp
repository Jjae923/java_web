<%@ page import="scope.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// session 영역에 있는 값 가져오기(key값으로 찾아오기)
	//MemberVO vo = (MemberVO)session.getAttribute("vo");
	MemberVO vo = (MemberVO)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 정보 출력</h2>
	<ul>
		<li>no : <%=vo.getNo()%></li>
		<li>name : <%=vo.getName()%></li>
		<li>age : <%=vo.getAge()%></li>
		<li>gender : <%=vo.getGender()%></li>
	</ul>
</body>
</html>