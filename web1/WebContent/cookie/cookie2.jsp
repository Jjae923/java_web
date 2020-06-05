<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// 쿠키 정보를 확인한 후
    	// 사용자 설정 값으로 페이지 보여주기
    	String language = "korea";
    
    	String cookie = request.getHeader("Cookie"); // 쿠키 가져오는 코드 
    	if(cookie!=null){
    		Cookie cookies[] = request.getCookies();
    		
    		for(int i=0;i<cookies.length;i++){
    			if(cookies[i].getName().equals("language")){
    				language = cookies[i].getValue();
    			}
    		}
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(language.equals("korea")){
			out.print("<h3>안녕하세요. 이것은 쿠키 예제입니다.</h3>");
		}else{
			out.print("<h3>Hello. This is Cookie example.</h3>");
		}
	%>
	<form action="setCookie1.jsp" method="post">
		<input type="radio" name="language" value="korea"
			<% if(language.equals("korea")){ %> checked <%} %> />한국어 페이지 보기		
		<input type="radio" name="language" value="english" 
			<% if(language.equals("english")){ %> checked <%} %> />영어 페이지 보기
		<input type="submit" value="설정" />
	</form>
</body>
</html>
