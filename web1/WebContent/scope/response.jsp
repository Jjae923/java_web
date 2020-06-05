<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 내장객체 : response → ★sendRedirect()★ --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// sendRedirect : 다른 페이지로 이동(외부 사이트도 가능)
		//response.sendRedirect("http://www.naver.com");
		
		request.setCharacterEncoding("utf-8");
		session.setAttribute("userid", request.getParameter("userid"));
		response.sendRedirect("request1.jsp");
		// sendRedirect로 페이지 이동을 했을 때
		// 사용자가 입력한 값을 request1.jsp에서 사용하고 싶다면?
		// session 이용 - ("key","value") 값을 담기
		
		
		//pageContext.forward("request1.jsp");
	%>	
</body>
</html>
