<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLogin.jsp</title>
<meta name="description" content="Ela Admin - HTML5 Admin Template">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 기본적으로 딸려오는 css -->
<link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
<link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
<link rel="stylesheet" href="../admin/assets/css/cs-skin-elastic.css">
<link rel="stylesheet" href="../admin/assets/css/style.css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>
<!-- 기본적으로 딸려오는 css 끝 -->

<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<c:url value='../js/member.js'/>"></script>
<script type="text/javascript">


 $(function(){
	$("input[name='adminId']").focus();

	$("button[type='submit']").click(function(){
		if($("input[name='adminId']").val().length<1){
			alert($("input[name='adminId']").parent().find("label").text() +"을(를) 입력하세요");
			$("input[name='adminId']").focus();
			event.preventDefault(); //이벤트 진행 막기					
			return false;  //each 탈출
		}else if(!validate_userid($("input[name='adminId']").val())){
			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			
			alert("이메일의 형식이 아닙니다. 예)xxx@aver.com");
			$("input[name='adminId']").focus();
			event.preventDefault();
			return false;
		}else if($("input[name='adminPwd']").val().length<1){
			alert($("input[name='adminPwd']").parent().find("label").text() +"을(를) 입력하세요");
			$("#adminPwd").focus();
			event.preventDefault(); //이벤트 진행 막기					
			return false;  //each 탈출
		}
		
	});
}); 
</script>

</head>
<body class="bg-dark">

	<div class="sufee-login d-flex align-content-center flex-wrap">
		<div class="container">
			<div class="login-content">
				<div class="login-form">
					<!-- form태그 시작 -->
					<form method="post" action="<c:url value='/grit.adminLogin.do'/>"
						name="frmlogin">
						<div class="form-group">
							<label>아이디</label> 
							<input type="text" class="form-control" placeholder="이메일 주소를 입력해 주세요." 
							name="adminId" id="adminId">
						</div>
						<div class="form-group">
							<label>비밀번호</label> 
							<input type="password" class="form-control"	placeholder="비밀번호를 입력해 주세요." name="adminPwd"
							id="adminPwd">
						</div>
						<div class="checkbox">
							<label> <input type="checkbox" name="chkSaveId"	id="saveId"
								<c:if test="${!empty cookie.ck_userid }">
						checked="checked"
					</c:if>>Remember Me
							</label> 
							<label class="pull-right"> <a href="#">비밀번호를 잊으셨나요?</a>
							</label>

						</div>
						<button type="submit"
							class="btn btn-success btn-flat m-b-30 m-t-30"> 로그인</button>
					</form>
					<!-- form태그 끝 -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
