<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>afterLogin.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/grit/css/modal_login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<c:url value='/grit/js/member.js'/>"></script>
<script type="text/javascript" src="<c:url value='/grit/jquery/jquery-3.3.1.min.js'/>"></script>
<script type="text/javascript">
$(function(){
	$("#change-pwd-ptn").click(function(){
		//비밀번호, 비밀번호 확인 일치여부 jq
		if($("#pwd1").val()!=$("#pwd2").val()){
			$(".validation").css("visibility", "visible");
			$(".validation").html("비밀번호를 일치시켜 주세요.")
			$("#pwd2").focus();
			event.preventDefault();
		}else{
			$(".validation").css("visibility", "hidden");
		}
	});
});
</script>
</head>
<body>
<!-- 	<div id="after-login-header">
		<div>
			<div class="profile-div"><img alt="프로필 사진" scr=""></div>
			<a href="#" data-toggle="modal" data-target="#modal3">{닉네임}</a>
		</div>
		<div>
			<div>
				<button type="button" class="main-btn-small" data-toggle="modal" data-target="#modal4"><img alt="" src="">3</button>
			</div>
			<div>
				<button type="button" class="main-btn-small" data-toggle="modal" data-target="#modal5"><img alt="" src="">4</button>
			</div>
		</div>
		<div>
			<input type="button" class="main-login-btn" value="Log out">
		</div>
	</div> -->

	
	<!-- modal부분시작 -->
	<!-- 프로필-->
	<div class="modal fade" id="modal3" role="dialog" >
		<div class="modal-dialog">
			<div class="modal-content content-size1">
			<button type="button" class="close" data-dismiss="modal" style="display: none;">&times;</button>
				<div class="profile-header">
					<div class="profile-img-box">
						<div class="set-box">
							<div class="display-i-b profile-header-btn" data-toggle="modal" data-target="#modal3-1" >
								<img src="<c:url value='/grit/img/icon/unlocked2.png'/>" class="profile-header-btn-img">
							</div>
							<div class="display-i-b profile-header-btn" data-toggle="modal" data-target="#modal3-2">
								<img src="<c:url value='/grit/img/icon/edit-document-icon.png'/>" class="profile-header-btn-img">
							</div>
						</div>
						<a href=""><img alt="개인회원이 등록한 사진" src="<c:url value='/grit/img/img1.png'/>" class="profile-img"></a>
					</div>
					<div class="profile-nick-box">
						<a href="" data-toggle="modal" data-target="#modal3-2">{ ${memVo.memNickname } }</a>
					</div>
				</div>
				<div class="profile-category">
					<div class="profile-position">
						<h4>포지션</h4>
						<div class="profile-category-btn align-c">카테고리</div>
						<div class="profile-category-btn align-c">카테고리</div>
						<div class="profile-category-btn align-c">카테고리</div>
						<div class="profile-category-btn align-c">카테고리</div>
						<div class="profile-category-btn align-c">카테고리</div>
					</div>
					<div class="profile-interests">
						<h4>관심분야</h4>
						<div class="profile-category-btn align-c">카테고리</div>
						<div class="profile-category-btn align-c">카테고리</div>
						<div class="profile-category-btn align-c">카테고리</div>
						<div class="profile-category-btn align-c">카테고리</div>
						<div class="profile-category-btn align-c">카테고리</div>
					</div>
					<div class="profile-intro">
						<h4>자기소개</h4>
						<div class="profile-intro-text">${memVo.memIntro }</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 프로필 -->
	<!-- 비밀번호 변경 -->
	<div class="modal fade" id="modal3-1" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content content-size1">
				<button type="button" class="close" data-dismiss="modal" style="display: none;">&times;</button>
				<form action="<c:url value='/grit/change-pwd.do'/>" method="post" name="frmPwd">
					<div>
						<input type="password" name ="currentPwd" placeholder="현재 비밀번호를 입력해주세요" class="modal-button">
						<input type="password" id="pwd1" name ="newPwd" placeholder="새 비밀번호를 입력해주세요" class="modal-button">
						<input type="password" id="pwd2" placeholder="비밀번호를 한번 더 입력해주세요" class="modal-button">
					</div>
					<p class="validation" style="margin-top:5px; text-align:right">validation message field</p>
					<div>
						<input id="change-pwd-ptn" type="submit" value="변경" class="modal-button">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 비밀번호 변경 -->
	<!-- 프로필 수정 -->
	<div class="modal fade" id="modal3-2" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content content-size2">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
					
				<div class="intro-size">
					<div class="image-div-size">
						<a><img alt="" src=""></a>
					</div>
					<div class="align-c">
						<input type="text" placeholder="닉네임을 입력해주세요" class="modal-button">
						<textarea class="modal-intro" placeholder="자기소개를 입력해주세요" ></textarea>
					</div>
				</div>
				<div class="intro-size">
					<div>
						<h4>포지션</h4>
						<div class="wrap">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						</div>  
					</div>
					<div>
						<h4>관심분야</h4>
						<div class="wrap">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						   	<input type="button" value="포지션 명" id="" class="button1">
						</div>  
					</div>
				</div>
				
			</div>
		</div>
	</div>
	<!-- 프로필 수정 -->
	
	<!-- 콘텐츠-->
	<div class="modal fade" id="modal4" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content content-size1">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
		</div>
	</div>
	<!-- 콘텐츠-->
	
	<!-- 공지사항 시작-->
	<div class="modal fade" id="modal5" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content content-size1">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<!-- 반복시작 -->
				<c:forEach var="i" begin="0" end="4">
					<c:set var="notiVo" value="${notiList[i] }"></c:set>
					<button class="notice-box" style="margin-top:20px;">
						<c:if test="${notiVo.newImgTerm<24 }">
							<img src="<c:url value='/grit/img/icon/new-icon3.png'/>" class="new-box">
						</c:if>
						<c:if test="${fn:length(notiVo.notiTitle)>15}">
							<div class="notice-title"><span>${fn:substring(notiVo.notiTitle,0,15) }...</span></div>
						</c:if>
						<c:if test="${fn:length(notiVo.notiTitle)<=15}">
							<div class="notice-title"><span>${notiVo.notiTitle }</span></div>
						</c:if>
						<div class="notice-regdate"><span><fmt:formatDate value="${notiVo.notiRegdate }" pattern="yyyy-MM-dd E"/></span></div>
					</button>
				</c:forEach>
				<!-- 반복끝 -->
			</div>
		</div>
	</div>
	<!-- 공지사항 종료-->
</body>
</html>