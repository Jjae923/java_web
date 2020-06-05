<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
%>
<%=format.format(date)%>