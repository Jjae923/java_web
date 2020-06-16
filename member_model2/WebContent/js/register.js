/**
 * register_validate.html 유효성 검증
 * 
 */
$(function(){ // 시작하겠다!
	$("#join").validate({ // join의 유효성 검증
		// 규칙명시
		rules:{
			userid:{//아이디(영문자,숫자,특수문자 조합으로 6~12자리)
				required : true,
				validID : true
			},
			userpw:{
				required : true,
				validPWD : true
			},
			confirmpwd:{
				required : true,
				validPWD : true,
				equalTo : "#userpw"				
			},
			gender:{
				required : true				
			},
			email:{
				required : true,
				email : true
			},
			mobile:{
				required : true,
				validMobile : true
			},
			hobby:{
				required : true
			}
		},
		// 메세지
		messages:{
			userid:{
				required : "아이디는 필수 속성입니다."
			},
			userpw:{
				required : "비밀번호는 필수 속성입니다."
			},
			confirmpwd:{
				required : "비밀번호는 필수 속성입니다.",
				equalTo : "이전 비밀번호와 다릅니다."				
			},
			gender:{
				required : "성별을 선택해 주세요."	
			},
			email:{
				required : "이메일은 필수 속성입니다.",	
				email : "이메일을 확인해 주세요"
			},
			mobile:{
				required : "핸드폰은 필수 속성입니다."
			},
			hobby:{
				required : "취미는 필수 속성입니다."
			}
		}
	})
	
	// 규칙을 검증할 메소드 추가
	$.validator.addMethod("validID",function(value){
		const regId = /(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{6,12}/;
		return regId.test(value);
	}, "아이디는 영문자, 숫자, 특수문자의 조합으로 6~12자리로 만들어야 합니다.");
	$.validator.addMethod("validPWD",function(value){
		const regPwd = /(?=^[A-Za-z])(?=.*\d)[A-Za-z\d]{8,12}/;
		return regPwd.test(value);
	}, "비밀번호는 영문자로 시작하고, 숫자의 조합으로 8~15자리로 만들어야 합니다.");
	$.validator.addMethod("validMobile",function(value){
		const regMobile = /^\d{3}\d{4}\d{4}&/;
		return regMobile.test(value);
	}, "-를 제외한 번호만 입력해 주세요");
})
