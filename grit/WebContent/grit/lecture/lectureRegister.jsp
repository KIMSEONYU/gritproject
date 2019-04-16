<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script src="../resource/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="resource/ckeditor/samples/sample.css">

<script type="text/javascript" src="<c:url value='/jquery/jquery-3.3.1.min.js'/>"></script>

	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	<link rel="stylesheet" href="../css/jquery-ui.css">
  	<script>
	 $( function() {
	    $( "#datepicker" ).datepicker({
	      showOn: "button",
	      buttonImageOnly: true,
	      buttonImage: "../img/icon/cal2.png",
	      changeYear:true,
			dateFormat:"yy-mm-dd",
			monthNames:["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
			dayNamesMin:["일","월","화","수","목","금","토"],
	      buttonText: "날짜 선택"
	    });
	    
	    $("#personup").click(function(){
		    var i=$("input[name='cMaxPerson']").val();
	    	$("input[name='cMaxPerson']").val(i*1+1);
	    });
	    $("#persondown").click(function(){
		    var i=$("input[name='cMaxPerson']").val();
		    if(i==0){
		    	return false;
		    }
	    	$("input[name='cMaxPerson']").val(i*1-1);
	    });
	    
	    $("#moneyup").click(function(){
	    	var i=$("input[name='cMoney']").val();
	    	$("input[name='cMoney']").val(i*1+1000);
	    });
	    $("#moneydown").click(function(){
	    	var i=$("input[name='cMoney']").val();
	    	if(i<1000){
	    		return false;
	    	}
	    	$("input[name='cMoney']").val(i*1-1000);
	    });
	});
  	</script>
<title>register.jsp</title>
<style type="text/css">
	div #ui-datepicker-div { width: 250px; }
</style>
</head>
<body>
	<form name="login" method="post" action="<c:url value='/grit/lecture/lectureRegister_ok.do'/>">
		<div class="pg_layout" style="position: relative; top: 35px;">
			<div style="width:100%">
				<div class="cont1" style="margin:0 auto;">
					<div class="pwrap">
						<p class="p">강의 제목</p>
						<input type="text" class="input size_85" name="cName" id="cName">
					</div>
					<div class="pwrap">
						<p class="p" style="position: relative; top: -110px;">강사 소개</p>
						<textarea class="textarea size_85" name="cTeacherIntro" style="height: 125px;"></textarea>
					</div>
					<div class="pwrap">
						<p class="p">카테 고리</p>
						<div>
							<ul style="height: 54px;">
								<li class="cate_box">카테고리1</li>
								<li class="cate_box">카테고리2</li>
								<li class="cate_box">카테고리3</li>
								<li class="cate_box">카테고리4</li>
								<li class="cate_box">카테고리5</li>
								<li class="cate_box">카테고리6</li>
								<li class="cate_box">카테고리7</li>
								<li class="cate_box">카테고리8</li>
								<li class="cate_box">카테고리9</li>
							</ul>
						</div>
						<div class="btnwrap1">
							<div class="cate_box" style="position : relative; top: -10px; left: 10px;">+ 직접 입력</div>
						</div>
					</div>
					<div class="clear"></div>
					<div class="imgwrap1">
						<div class="l_imgwrap">
							<img class="main_img" src=""></img>
						</div>
						<div class="r_imgwrap">
							<img class="sub_img" src=""></img> <img class="sub_img" src=""></img>
							<img class="sub_img" src=""></img> <img class="sub_img" src=""></img>
						</div>
					</div>
					<div class="pwrap" style="position: relative; top: -20px;">
						<p class="p" style="position: relative; top: -30px;">강사 요약</p>
						<textarea class="textarea size_85" name="cSummary" style="position: relative; top: 25px; height: 75px;"></textarea>
					</div>
					
					<div style="position: relative; top: 10px;">
						<div>
							<p class="p">강의 상세</p>
						</div>
						<div>
							<textarea class="textarea" id="editor1" style="width: 1024px;" name="cDetail"></textarea>
							<script>
		  						 CKEDITOR.replace( 'editor1', {
		  							 width:640,
		  							 height:200
							});
							</script>
						</div>
						
					</div>
	
					<div class="pwrap">
						<p class="p size_15">강의날짜</p>
						<div class="in_wrap">
							<input type="text" placeholder="달력을 클릭해주세요" class="input b_left" name="cDate" id="datepicker" readonly="readonly" >
							<!-- <div style="float:left;">
								<img src="../img/icon/cal2.png" style="pointer:cursor;">
							</div> -->
							<div class="btnwrap2" style="float:right; position:relative; right:207px;">
								<select class="b_left" name="cLine">
									<option>오전</option>
									<option>오후</option>
								</select> 
								<select class="b_left" name="cTime">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
									<option>6</option>
									<option>7</option>
									<option>8</option>
									<option>9</option>
									<option>10</option>
									<option>11</option>
									<option>12</option>
								</select>
								<span style="top:6px; margin-left:2px; position: relative; font-size:15px;">시</span>
							</div>
						</div>
					</div>
					<div class="pwrap">
						<p class="size_15">강의장소</p>
						<div class="in_wrap">
							<input type="text" class="b_left" name="cLocation">
							<div class="btnwrap2">
								<div class="btn_box">검색</div>
							</div>
						</div>
					</div>
					<div class="pwrap">
						<p class="p size_15">수강인원</p>
						<div class="in_wrap">
							<input type="text" class="input b_left" name="cMaxPerson" readonly="readonly" value="0" style="text-align:right;">
							<div class="btnwrap2">
								<div class="btn_box" style="display: inline-block;" id="personup">▲</div>
								<div class="btn_box" style="display: inline-block;" id="persondown">▼</div>
							</div>
						</div>
					</div>
					<div class="pwrap">
						<p class="p size_15">수강료</p>
							<span class="span">
								<input class="input" type="radio" name="cPay" value="N"> 무료 
								<input class="input" type="radio" name="cPay" value="Y"> 유료
							</span>
					</div>
					<div class="pwrap">
						<p class="p size_15">가격</p>
						<div class="in_wrap">
							<input type="text" class="input b_left t_center" name="cMoney" value="0">
							<div class="btnwrap2">
								<div class="btn_box" style="display: inline-block;" id="moneyup">▲</div>
								<div class="btn_box" style="display: inline-block;" id="moneydown">▼</div>
							</div>
						</div>
					</div>
					<div class="pwrap">
						<p class="p size_15" style="position: relative; top: 5px;">입금계좌</p>
						<div class="slctwrap1" style="height: 80px;">
							<select name="select cBank" class="b_left" style="height: 35px;">
								<option>은행선택</option>
								<option>국민은행</option>
								<option>신한은행</option>
								<option>하나은행</option>
							</select> 
							<input type="text" class="input in_mg" name="cAccount" style="height: 35px;">
						</div>
					</div>
					<div class="clear"></div>
					<div class="pwrap">
						<input type="checkbox" class="input chk_fleft" name="chk1">
						<p class="p" style="position: relative; top: 10px;">
							강사 약관에 동의합니다. <a href="#">강사 약관 보기</a>
						</p>
					</div>
					<div class="btnwrap1">
						<input type="submit" class="input btn_box" style="width: 150px; height: 50px;" value="강의 등록하기">
					</div>
				</div>	
			</div>
		</div>
	</form>
	<%@ include file="../inc/footer.jsp"%>

