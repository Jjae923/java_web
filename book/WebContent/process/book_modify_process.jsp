<%@page import="domain.BookVO"%>
<%@page import="persistence.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// book_modify.jsp 에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("code");
	int price = Integer.parseInt(request.getParameter("price"));
	
	// 데이터베이스 작업 후 성공하면 book_selectAll.jsp
	// 실패하면 index.jsp로 이동
	BookDAO dao = new BookDAO();
	int result = dao.bookModify(code, price);
	
	if(result > 0){
		response.sendRedirect("../book_selectAll.jsp");
	}else {
		response.sendRedirect("../index.jsp");
	}
%>
