<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// cookie2.jsp에서 사용자가 선택한 값을 쿠키에 저장 후 
	// 응답 헤더에 쿠키 붙여서 보내기
	Cookie cookie = new Cookie("language", request.getParameter("language"));
	cookie.setMaxAge(60*60*24);
	response.addCookie(cookie);
	response.sendRedirect("cookie2.jsp");
	%>
