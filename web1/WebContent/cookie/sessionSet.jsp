<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// session 값 담기
	session.setAttribute("name", "session test!!");
	// 원래 페이지로 이동
	response.sendRedirect("sessionTest.jsp");
%>