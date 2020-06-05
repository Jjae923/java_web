<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 사용자가 입력한 정보 가져오기
	// userAdd.jsp
	request.setCharacterEncoding("utf-8");
	String userName = request.getParameter("userName");
	String birthYear = request.getParameter("birthYear");
	String addr = request.getParameter("addr");
	String mobile = request.getParameter("mobile");	
	
	// DB 처리하기 - User 추가
	Class.forName("oracle.jdbc.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "javadb";
	String password = "12345";
	Connection con = DriverManager.getConnection(url, user, password);
	
	String sql = "insert into userTBL values(user_seq.nextVal,?,?,?,?)";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1, userName);
	pstmt.setInt(2, Integer.parseInt(birthYear));
	pstmt.setString(3, addr);
	pstmt.setString(4, mobile);
	
	int result = pstmt.executeUpdate();
	// 사용자에게 결과 페이지 보여주기 - 전체 User 화면 보여주기
	if(result > 0){
		response.sendRedirect("listProcess.jsp");
	}
%>
</body>
</html>
