/**
 * 로그인 후 보여줄 메뉴 화면 구성
 */
$(function() {
	// 상단에 보여지던 메뉴 중 register 메뉴 없애기
	$('#2').detach();
	// Login 메뉴 없앵기
	$('#3').detach();
	
	// ~ 님 반갑습니다.와 버튼 3개 추가하기
	let tag = "<span class='navbar-text'>"+name+" 님 반갑습니다.</span>";
	tag+= "&nbsp;&nbsp;";
	tag+= " <button type='button' id='modify' class='btn btn-success'>비밀번호 수정</button>";
	tag+= "&nbsp;&nbsp;";
	tag+= " <button type='button' id='logout' class='btn btn-primary'>로그아웃</button>";
	tag+= "&nbsp;&nbsp;";
	tag+= " <button type='button' id='leave' class='btn btn-danger'>회원탈퇴</button>";
	$("#navbarCollapse").append(tag);
})
