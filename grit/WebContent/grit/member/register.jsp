<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
 <html class="no-js" lang="">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Ela Admin - HTML5 Admin Template</title>
    <meta name="description" content="Ela Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 기본적으로 딸려오는 css -->
    <link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
    <link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
    <link rel="stylesheet" href="../admin/assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="../admin/assets/css/style.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
    <!-- 기본적으로 딸려오는 css 끝 -->
    
    
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="<c:url value='../js/member.js'/>"></script>

    <script type="text/javascript">
    $(function(){
    	
    	$(".form-control").eq(0).focus();
    	
    	$("button[type='submit']").click(function(){
       		
    		if($(".form-control").eq(0).val().length<1){
	    		alert("이름을 입력해주세요.");
	    		$(".form-control").eq(0).focus();
	    		event.preventDefault(); //이벤트 진행 막기					
				return false;  //each 탈출
    		}else if($(".form-control").eq(1).val().length<1){
    			alert("아이디를 입력해주세요.");
    			$(".form-control").eq(1).focus();
    			event.preventDefault();
    			return false;
    		}else if(!validate_userid($(".form-control").eq(1).val())){
    			alert("잘못된 아이디");
    			$(".form-control").eq(1).focus();
    			event.preventDefault();
    			return false;
    		}else if($(".form-control").eq(2).val().length<1){
    			alert("비밀번호를 입력해주세요.");
    			$(".form-control").eq(2).focus();
    			event.preventDefault();
    			return false;
    		}else if($("input[name='adminPwd']").val()!=$("input[name='adminPwd1']").val()){
    			alert("비밀번호가 일치하지않습니다.");
    			$(".form-control").eq(3).focus();
    			event.preventDefault();
    			return false;
    		}else if(!validate_pwd($("input[name='adminPwd1']").val())){
    			alert("비밀번호는 0~9까지 a~z, A~Z, 특수문자를 모두 포함하여 1~15글자를 만족을 하셔야합니다.");
    			$(".form-control").eq(2).focus();
    			event.preventDefault();
    			return false;
    		}else if($(".form-control").eq(4).val().length<1){
    			alert("핸드폰번호를 입력해주세요.");
    			$(".form-control").eq(4).focus();
    			event.preventDefault();
    			return false;
    		}else if(!validate_phone($(".form-control").eq(4).val())){
    			alert('잘못된 휴대폰 번호입니다.');
    			$(".form-control").eq(4).focus();
   			    event.preventDefault();
   			    return false;
    		}
    	});
    });
    
    
    </script>
    

</head>
<body class="bg-dark">

    <div class="sufee-login d-flex align-content-center flex-wrap">
        <div class="container">
            <div class="login-content">
                <div class="login-logo">
                </div>
                <div class="login-form">
                    <form action="register_ok.do" method="post" name="">
                        <div class="form-group">
                            <label>이름</label>
                            <input type="text" class="form-control" placeholder="이름" name="adminName">
                        </div>
                        <div class="form-group">
                            <label>아이디</label>
                            <input type="text" class="form-control" placeholder="이메일 " name="adminId">
                            <span id="adminId"></span>
                        </div>
                        <div class="form-group">
                            <label>비밀번호</label>
                            <input type="password" class="form-control" placeholder="비밀번호" name="adminPwd">
                            <input type="password" class="form-control" placeholder="비밀번호 확인" name="adminPwd1">
                            <span id="adminPwd"></span>
                        </div>
                        <div class="form-group">
                            <label>전화번호 [ "-"를 함께 입력해주세요. ]</label>
                            <input type="text" class="form-control" placeholder="전화번호" name="adminHp" id="adminHp">
                        </div>
                        
                        <button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30">회원가입</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
