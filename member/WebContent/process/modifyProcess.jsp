<%@page import="domain.MemberVO"%>
<%@page import="persistence.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//modifyForm.jsp 데이터 가져오기
	// 현재비밀번호, 바꿀비밀번호, 바꿀비밀번호 한번 더
	request.setCharacterEncoding("utf-8");
	String current_password = request.getParameter("current_password");
	String new_password = request.getParameter("new_password");
	String confirm_password = request.getParameter("confirm_password");
	//new_password와 confirm_password가 같은지 확인 후
	//같지 않으면 modifyForm.jsp 돌려보내기
	if(new_password.equals(confirm_password)){		
		//현재 비밀번호가 일치하면
		//새로운 비밀번호로 수정 후
		MemberVO login = (MemberVO)session.getAttribute("login");
		String userid = login.getUserid();
		//세션 삭제 후 로그인 페이지로 이동
		MemberDAO dao = new MemberDAO();
		int result=dao.passwordUpdate(userid, new_password, current_password);
		if(result>0){
			session.invalidate();
			response.sendRedirect("../index.jsp");
		}		
	}else{
		//현재 비밀번호가 틀린경우 다시 modifyForm.jsp 를 보여주기
		response.sendRedirect("../view/modifyForm.jsp");
	}
%>