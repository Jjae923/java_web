/**
 * 메뉴에서 보여지는 버튼 동작 설정
 */
$(function() {
	$("#modify").click(function() {
		location.href='../view/modifyForm.jsp';
	})
	$("#logout").click(function() {
		location.href='../process/logoutProcess.jsp';
	})
	$("#leave").click(function() {
		location.href='leaveForm.jsp';		
	})
})
