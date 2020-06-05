<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 모든 session 제거
	session.invalidate();
	// 원 페이지로 이동
	response.sendRedirect("sessionTest.jsp");
%>