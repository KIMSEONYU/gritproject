/**
 * js/member.js
 */
/*	$(function(){
		$("#email2").change(function(){
			if($(this).val()=="etc"){
				$("#email3").val("");
				$("#email3").css("visibility","visible");
				$("#email3").focus();
			}
			else{
				$("#email3").css("visibility","hidden");	
			}
		});
		$("#btnChkId").click(function(){
			open("/mymvc/member/checkUserid.do?userid="+$("#userid").val(),"chk",
				"width=550,height=250,left=0,top=0,location=yes,resizable=yes");
		//js 파일같은경우에는 클라이언트에서 실행되는 파일이기 때문에 jsp관련된 모든것을 
		//사용할수 없기 때문에 컨텍스트 패스를 직접 다 써줘야함
		});//change
		$("#btnZipcode").click(function(){
			open("/mymvc/zipcode/zipcode.do","zip","width=550,height=700,left=0,top=0,location=yes,resizable=yes");
		});
	});*/
	function validate_userid(userid){
		var pattern=new RegExp(/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/);
		return pattern.test(userid);//정규표현식을 만족하면 true, 아니면 false
		/*
		 * 조건
		 * 알파벳or숫자 1글자 이상  @ 2글자이상. 2글자이상 
		 * 
		 * 
			정규식 /^[a-zA-Z0-9_]+$/g
			a에서 z사이의 문자, A~Z사이의 문자, 0에서 9사이의 숫자나 _로 시작하거나 끝나야한다는 의미
			닫기 대괄호 (]) 뒤의 +기호는 이패턴이 한 번 또는 그이상 반복 된다는 의미
		*/
	}
	function validate_phone(ph){
		var pattern=new RegExp(/(01[0|1|6|9|7])[-](\d{3}|\d{4})[-](\d{4}$)/g);
		return pattern.test(ph);//정규표현식을 만족하면 true, 아니면 false	
		/*
			010,011,016,019,017 - (0~9)3~4자리 - (0~9) 4자리 만족해야한다.
			- 필수로 붙여야한다.
		*/
	}
	
	function validate_pwd(pwd){
		var pattern = new RegExp
		(/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{1,15}$/g);
		return pattern.test(pwd);  //
		//0~9까지 a~z, A~Z, 특수문자를 모두 포함하여 1~15글자를 만족해야 하는 정규식 
	}