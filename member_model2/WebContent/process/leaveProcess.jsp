<%@page import="domain.MemberVO"%>
<%@page import="persistence.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	request.setCharacterEncoding("utf-8");
	// leaveForm.jsp에서 넘긴 값 가져오기
	String userid = request.getParameter("userid");
	String password = request.getParameter("current_password");
	// DB 처리 후 탈퇴 성공하면
	// 세션 제거 후 index 페이지로 이동
	MemberDAO dao = new MemberDAO();
	
	int result = dao.leave(userid, password); 
	
	if(result > 0) {
		response.sendRedirect("../index.jsp");
	}else {
		// 탈퇴 실패 시 leaveForm.jsp 이동
		response.sendRedirect("../view/leaveForm.jsp");
	}
%> --%>

<% 
	//leaveForm.jsp에서 넘긴 값 가져오기
	String userid = request.getParameter("userid");
	String password = request.getParameter("current_password");
	MemberDAO dao = new MemberDAO();
	int result = dao.leave(userid, password);
	if(result>0){
		//DB 처리 후 탈퇴 성공하면		
		//세션 제거 후 index 페이지로 이동
		session.removeAttribute("login");
		out.print("<script>");
		out.print("alert('회원탈퇴 성공');");
		out.print("location.href='../index.jsp'");
		out.print("</script>");
	}else{
	//탈퇴 실패시 leaveForm.jsp 이동
		out.print("<script>");
		out.print("alert('비밀번호를 확인해 주세요');");
		out.print("location.href='../view/leaveForm.jsp';");
		out.print("</script>");
	}
%>
