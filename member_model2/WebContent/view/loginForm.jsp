<%@page import="domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<% 
	MemberVO login = (MemberVO)session.getAttribute("login");
	if(login==null) {
%>
<form class="form-signin" name="loginform" action="../login.do" method="post">
  <div class="form-label-group">
    <input type="text" id="userid" name="userid" class="form-control" placeholder="id" required autofocus>
    <label for="userid">아이디</label>
  </div>

  <div class="form-label-group">
    <input type="password" id="current_password" name="password" class="form-control" placeholder="Password" required>
    <label for="pass">비밀번호</label>
  </div>

  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  <p class="mt-5 mb-3 text-muted text-center">&copy; 2019</p>
</form>
<%}else { %>
<script>
	let name = '<%=login.getName() %>'; // 문자열임을 알려주기 위한 ''(홑따옴표)
</script>
<script src="../js/menu.js"></script>
<% } %>
<script src="../js/button.js"></script>
<%@ include file="../layout/footer.jsp" %>
