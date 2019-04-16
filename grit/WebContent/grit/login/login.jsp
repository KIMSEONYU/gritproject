<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/grit/css/modal_login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<c:url value='/grit/js/member.js'/>"></script>
<script type="text/javascript" src="<c:url value='/grit/jquery/jquery-3.3.1.min.js'/>"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#validation").css("visibility","hidden");
		
		$("#memUserid").keyup(function(){
			if(!validate_userid($(this).val())||$(this).val().length<2){
				$("#validation").html("아이디 규칙에 맞지 않습니다.");
				$("#validation").css("visibility","visible");
			}else{
				$.ajax({
					url:"<c:url value='/grit/index-ajaxCheckUserid.do'/>",
					type:"post",
					data:"memUserid="+$(this).val(),
					success:function(res){
						//alert(res);	//1,2
						var str="";
						if(res==1){//사용 가능한 아이디
							str="사용 가능한 아이디"
						}
						else if(res==2){//사용 불가능한 아이디
							str="이미 등록된 아이디"
						}
						$("#validation").html(str);
						$("#validation").css("visibility","visible");
					},
					error:function(xhr,status,error){
						alert("에러 : "+error);
					}
				});
			}
		});
	 	$("#checkInfo").click(function(){
			//이름, 아이디 ,비밀번호 필수
		/* 	if($("#memName").val().length<1){
				$("#validation").css("visibility","visible");
				$("#memName").focus();
				$("#validation").html("이름을 입력해주세요.");
				return false;
			}
			 else if(!validate_userid($("#memUserid").val())){
				$("#validation").css("visibility","visible");
				$("#validation").html("이메일형식이 아닙니다.");
				$("#memUserid").focus();
				return false
			}		
			else if(!validate_pwd($("#pwd").val())){
				alert("비밀번호는 숫자나 알파벳, 특수문자를 모두 포함하여 15글자 이내로 입력해야 합니다.");
				$("#pwd").focus();
				event.preventDefault();
			}
			
			else if($("#pwd").val()!=$("#pwd2").val()){
				alert("비밀번호를 일치 시켜주세요");
				$("#pwd2").focus();
				event.preventDefault();
			}
			else if(!validate_phone($("#hp2").val())
					||!validate_phone($("#hp3").val())){
				alert("휴대폰은 숫자만 입력해야 합니다.");
				$("#hp2").focus();
				event.preventDefault();				
			}
			else if($("#chkId").val()!="Y"){
				alert("중복확인을 하셔야 합니다.");
				$("#btnChkId").focus();
				event.preventDefault();				
			}
			  */
		}); 
	});
</script>
</head>
<body>
	<div class="container" >
		<div class="modal fade" id="modal1" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content content-size1">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title">로그인</h3>
					<form action="<c:url value='/grit/index-login.do'/>" method="post" name="frmLogin">
						<div>
							<input name="memUserid" type="text" placeholder="계정(이메일)을 입력해주세요" class="modal-button modal_margin30">
							<input name="memPwd"type="password" placeholder="비밀번호를 입력해 주세요" class="modal-button modal_margin5">
							<p style="margin-top:5px; text-align:right">validation message field</p>
							<div>
								<input type="submit" value="로그인" class="modal-button login">
							</div>
							<div class="findpwd">
								<a href="#" data-toggle="modal" data-target="#modal1-1">패스워드가 기억나지 않나요?</a>
							</div>
						</div>
						<div>
							<input id="kakao-login-btn" type="button" value="카카오로 로그인 하기" class="modal-button kakao modal_margin80">
							<input type="button" value="페이스북으로 로그인 하기" class="modal-button facebook modal_margin5">
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- modal login -->

		<!-- modal findpwd -->
		<div class="modal" id="modal1-1" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content content-size1">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title">비밀번호 찾기</h3>
					<input type="text" placeholder="여기에 계정(이메일)을 입력해주세요." class="modal-button">
					<input type="button" value="비밀번호 재발급하기" class="modal-button">
					<p>[!] 가입하신 이메일로 비밀번호 재발급 링크를 보내드립니다.</p>	
				</div>
			</div>
		</div>
		<!-- modal findpwd -->
		<!-- modal join -->
		<!-- form태그를 modal창 전부를 묶어서 post되는지 확인 -->
		<div class="modal fade" id="modal2" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content content-size1">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<div>
						<div><img src="#" class="image-div-size"></div>
						<div class="modal-button">
							<span>개인정보 취급 방침에 동의 <a href="#">[보기]</a></span>
							<img src="${pageContext.request.contextPath}/grit/img/icon/check.png" alt="" class="float-r check-img">
						</div>
						<div class="modal-button">
							<span>서비스 이용약관에 동의 <a href="#">[보기]</a></span>
							<img src="${pageContext.request.contextPath}/grit/img/icon/check.png" alt="" class="float-r check-img">
						</div>
					</div>
					<div>
						<input type="button" value="직접 계정 생성하기" class="modal-button" data-toggle="modal" data-target="#modal2-1">
						<input type="button" value="카카오로 가입하기" class="modal-button">
						<input type="button" value="페이스북으로 가입하기" class="modal-button">
					</div>
				</div>
			</div>
		</div>
		<!-- modal-join -->
		<!-- modal 계정 직접생성 -->
		<form action="<c:url value='/grit/index-register.do'/>" name="frmJoin" method="post">
			<div class="modal" id="modal2-1" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content content-size1">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<div>
							<input type="text" placeholder="이름을 입력해주세요" class="modal-button modal_margin30" name="memName" id="memName">
							<input type="text" placeholder="계정으로 사용하실 이메일 입력해주세요." class="modal-button" name="memUserid" id="memUserid">
							<input type="password" placeholder="비밀번호를 입력해주세요." class="modal-button" name="memPwd" id="memPwd">
							<input type="password" placeholder="비밀번호를 한번 더 입력해주세요." class="modal-button">
							<input type="text" placeholder="휴대폰 전화번호를 입력해주세요" class="modal-button" name="memHp" id="memHp" maxlength="11">
							<p>[!] 이메일을 허위로 작성할 경우, 비밀번호를 분실 했을 때 비밀번호를 찾을 수 없습니다.</p>
							<p id="validation" class="validation">validation message field</p>
							<input type="button" value="다음" id="checkInfo"class="modal-button" data-toggle="modal" data-target="#modal2-2">				
						</div>
					</div>
				</div>
			</div>
			<!-- modal 계정 직접생성 -->
			<!-- modal 프로필 생성 -->
			<div class="modal" id="modal2-2" role="dialog">
				<div class="modal-dialog">
					
					<div class="modal-content content-size2">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						
						<div class="intro-size">
							<div class="image-div-size">
								<a><img alt="" src=""></a>
							</div>
							<div class="align-c">
								<input type="text" placeholder="닉네임을 입력해주세요" class="modal-button" name="memNickname">
								<textarea class="modal-intro" placeholder="자기소개를 입력해주세요" name="memIntro"></textarea>
							</div>
						</div>
						<div class="intro-size">
							<div>
								<h4>포지션</h4>
								<div class="wrap">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								</div>  
							</div>
							<div>
								<h4>관심분야</h4>
								<div class="wrap">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								   	<input type="button" value="포지션 명" class="button1">
								</div>  
							</div>
							<p class="validatio-msg">validation message field</p>
							<input type="submit" value="계정생성완료" id="">
						</div>
						
					</div>
				</div>
			</div>
		</form>
		<!-- modal 프로필 생성 -->
	</div>
</body>
</html>
