<%@page import="domain.MemberVO"%>
<%@page import="persistence.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// loginForm.jsp에서 넘긴 값 가져오기
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	
	// DB 확인 후 존재하는 사용자라면
	MemberDAO dao = new MemberDAO();
	MemberVO vo = dao.isLogin(userid, password);
	
/* 	if(vo != null) {
		// 세션에 값을 담고 index.jsp 이동
		session.setAttribute("login", vo);
		response.sendRedirect("../index.jsp");
	}else {
		// 존재하지않는 사용자라면 loginForm.jsp 보여주기
		response.sendRedirect("../view/loginForm.jsp");
	}  */	
	
	if(vo != null) {
		// 세션에 값을 담고 loginForm.jsp 이동
		session.setAttribute("login", vo);
	}
		response.sendRedirect("../view/loginForm.jsp");
%>
