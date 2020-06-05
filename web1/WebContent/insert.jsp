<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 가져오는 값에 대한 한글처리(post일 때 꼭 필요)
	request.setCharacterEncoding("utf-8");
%>
<%=request.getParameter("name")%>