/**
 * modifyForm.jsp 유효성 검증하기
 */

$(function(){
	$("#modifyform").validate({
		// 규칙명시
		rules:{
			current_password:{
				required : true				
			},
			new_password:{
				required : true,
				validPWD : true
			},
			confirm_password:{
				required : true,
				equalTo : "#new_password"
			}
		},
		// 메세지
		messages:{
			current_password:{
				required : "수정할 비밀번호를 입력해주세요."
			},
			new_password:{
				required : "새 비밀번호는 필수 입력 사항입니다."
			},
			confirm_password:{
				required : "비밀번호 확인은 필수 입력 사항입니다.",
				equalTo : "입력한 비밀번호와 일치하지 않습니다."
			}
		}
	})
	// 유효성 검증
	$.validator.addMethod("validPWD",function(value){
		const regPwd = /(?=^[A-z])(?=.*\d)(?=.*[!@#$%^&*])[A-z\d!@#$%^&*]{8,15}$/;
		return regPwd.test(value);
	}, "비밀번호는 영문자, 숫자, 특수문자의 조합으로 8~15자리 만들어야 합니다.");
})
