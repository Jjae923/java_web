<%@page import="persistence.TestDAO"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection con = TestDAO.getConnection();
	if(con!=null){
		out.print("연결되었습니다.");
	}
%>
