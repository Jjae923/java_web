<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	
	if(!id.isEmpty() && !name.isEmpty()){
		out.print("true");
	}else {
		out.print("false");
	}
%>
