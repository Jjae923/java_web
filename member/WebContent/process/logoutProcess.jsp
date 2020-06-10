<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 세션 해제
	session.removeAttribute("login");
	response.sendRedirect("../index.jsp");
%>