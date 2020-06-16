/**
 *  signupForm.html 폼 유효성 검증
 */
$(function(){
	$("#signupForm").validate({
		// 검증 규칙
		rules:{
			username:{ // 이름은 필수 속성, 글자는 2~4 허용
				required:true,
				minlength:2,
				maxlength:4
			},
			password:{ // 비밀번호는 필수, 글자는 8~15 허용
				required:true,
				rangelength:[8,15] // minlength, maxlength
			},
			confirm_password:{ // 비밀번호는 필수, 글자는 8~15 허용, password랑 값 일치
				required:true,
				rangelength:[8,15],
				equalTo : "#password"
			},
			email:{ // 이메일 필수, email 검증
				required:true,
				email : true
			},
			policy:{
				required:true				
			},
			topic:{ // newsletter받기가 체크되어야 하고, 최소 2개 선택
				required : "#newsletter:checked",
				minlength : 2
			}
		},
		// 메세지
		messages:{
			username:{ // 이름은 필수 속성, 글자는 2~4 허용
				required:"이름은 필수 요소입니다.",
				minlength:"이름은 최소 2자리 입니다.",
				maxlength:"이름은 최대 4자리까지 허용됩니다."
			},
			password:{ // 비밀번호는 필수, 글자는 8~15 허용
				required:"비밀번호는 필수 요소입니다.",
				rangelength:"비밀번호는 8~15자리까지 허용됩니다."
			},
			confirm_password:{ // 비밀번호는 필수, 글자는 8~15 허용, password랑 값 일치
				required:"비밀번호는 필수 요소입니다.",
				rangelength:"비밀번호는 8~15자리까지 허용됩니다.",
				equalTo : "이전 비밀번호와 다릅니다."
			},
			email:{ // 이메일 필수, email 검증
				required:"이메일은 필수 요소입니다.",
				email : "이메일 형식을 확인해 주세요."
			},
			policy:{
				required:"우리 정책에 동의를 필요로 합니다."				
			},
			topic:"관심사를 적어도 2개는 표시하세요"
		}, // messages end
		// 에러 메세지 위치 지정
		errorElement:"em",
		errorPlacement : function(error, element){
			error.addClass("help-block");
			if(element.prop("type") === "checkbox"){
				error.insertAfter(element.next("label"));
			}else {
				error.insertAfter(element);
			}
		}
	}) // 검증
	
	$("#newsletter").click(function() {
		let topics = $("#newsletter_topics");
		if(topics.css("display")==="none"){
			$(topics).css("display", "inline-block");
		}else {
			$(topics).css("display","none");
		}
	})
})