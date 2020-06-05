<%@ page import="domain.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- User 클래스 사용하고 싶다면? --%>
<jsp:useBean id="user" class="domain.User"/> <%-- User user = new User(); 대체 --%>
<jsp:setProperty property="name" name="user" value="홍길동"/> <%-- user.setName("홍길동"); 대체 --%>
<h1><jsp:getProperty property="name" name="user"/></h1> <%-- <h1><%=user.getName()%></h1> 대체 --%>
<%
/* 	User user = new User();
	user.setName("홍길동"); */
%>
<%-- <h1><%=user.getName()%></h1> --%>