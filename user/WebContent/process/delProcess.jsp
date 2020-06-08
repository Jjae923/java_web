<%@page import="domain.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// userDel.jsp에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
	String username = request.getParameter("userName");
	// DB 탈퇴 작업
	UserDAO dao = new UserDAO();
	int result = dao.userDelete(no, username);
	// 탈퇴가 성공하면 index.jsp 이동
	if(result > 0){
		response.sendRedirect("../index.jsp");
	}
%>
