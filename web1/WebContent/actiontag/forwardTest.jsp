<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- action tag : jsp 페이지에서 자바코드를 사용하기 위해
	 스크립틀릿 등을 사용하지 않ㄴ고 다른 페이지의 서블릿이나
	 자바빈의 객체에 접근할 수 있도록 태그로 구성됨

	pageContext.forward()
	pageContext.include()
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="../insert.jsp"></jsp:forward>
</body>
</html>
