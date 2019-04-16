<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<%@ include file="../login/login.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
<meta charset="UTF-8">
<title>강의 상세보기</title>
<script type="text/javascript">
	var IMP = window.IMP; // 생략가능

	IMP.init('imp07537802'); // 가맹점 식별 코드
	function pay() {
		IMP.request_pay({
			pg : 'html5_inicis',
			pay_method : 'card',
			merchant_uid : 'merchant_' + new Date().getTime(),
			name : '주문명:결제테스트',
			amount : 14000,
			buyer_email : 'iamport@siot.do',
			buyer_name : '구매자이름',
			buyer_tel : '010-1234-5678',
			buyer_addr : '서울특별시 강남구 삼성동',
			buyer_postcode : '123-456'
		}, function(rsp) {
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}

			alert(msg);
		});
	}
</script>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

/* 상단 강의명~상세,참가,Comment리스트 전까지의width와 기본 가운데 정렬 */
.topbox {
	max-width: 1024px;
	min-width: 1024px;
	margin: 0 auto;
} /* //topbox */

/* ------도구모음------ */

/* height에 대한 도구 */
.h100 {
	height: 100%;
}

.h90 {
	height: 90%;
}

.h80 {
	height: 80%;
}

.h70 {
	height: 70%;
}

.h60 {
	height: 60%;
}

.h50 {
	height: 50%;
}

.h40 {
	height: 40%;
}

.h30 {
	height: 30%;
}

.h20 {
	height: 20%;
}

.h10 {
	height: 10%;
}

.line-h40 {
	line-height: 40px
}

/* width에 대한 도구 */
.w100 {
	width: 100%;
}

.w90 {
	width: 90%;
}

.w80 {
	width: 80%;
}

.w70 {
	width: 70%;
}

.w60 {
	width: 60%;
}

.w50 {
	width: 50%;
}

.w40 {
	width: 40%;
}

.w30 {
	width: 30%;
}

.w20 {
	width: 20%;
}

.w10 {
	width: 10%;
}

/* float에 대한 도구 */
.fl-r {
	float: right;
}

.fl-l {
	float: left;
}

.clear-b {
	clear: both;
}

/* text-align에 대한 도구 */
.ali-c {
	text-align: center;
}

.ali-r {
	text-align: right;
}

.ali-l {
	text-align: left;
}

/* border에 대한 도구 */
.bor-s {
	border: 1px solid lightgray;
}

.bor-ri {
	border-right: 1px solid lightgray;
}

.bor-bo {
	border-bottom: 1px solid lightgray;
}

.bor-ra {
	border-radius: 10px;
}

/* background-color 영역표시를 위한 도구 */
.bkg {
	background-color: lightgray;
}

/* display에 대한 도구 */
.dis-block {
	display: block;
	cursor: pointer;
}

.dis-none {
	display: none;
}
/* ---------------- */
</style>
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#l1").css("background-color", "lightgray");
		$("#infodetail").css("display", "");
		$("#profilelist").css("display", "none");
		$("#comment").css("display", "none");

		$("#l1").click(function() {
			$("#l1").css("background-color", "lightgray");
			$("#l2").css("background-color", "");
			$("#l3").css("background-color", "");
			$("#infodetail").css("display", "");
			$("#profilelist").css("display", "none");
			$("#comment").css("display", "none");
		});
		$("#l2").click(function() {
			$("#l2").css("background-color", "lightgray");
			$("#l3").css("background-color", "");
			$("#l1").css("background-color", "");
			$("#infodetail").css("display", "none");
			$("#profilelist").css("display", "");
			$("#comment").css("display", "none");
		});
		$("#l3").click(function() {
			$("#l3").css("background-color", "lightgray");
			$("#l1").css("background-color", "");
			$("#l2").css("background-color", "");
			$("#infodetail").css("display", "none");
			$("#profilelist").css("display", "none");
			$("#comment").css("display", "");
		});
	});
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script>
	$(document).ready(function() {
		$('.slider').bxSlider({
			auto : true,
			infiniteLoop : true,
			speed : 1000
		});
	});
</script>
</head>
<body>

	<!-- //////////페이지 전체적 틀 1024px에 margin:0 auto로 가운데정렬이 되어있는 상태입니다////////// -->
	<div class="topbox">
		<!-- 상단 강의명과 참가비를 포함한 div태그 -->
		<div>
			<div class="ali-c" style="height: 100px;">
				<div class="fl-l bkg h100" style="width: 84%; font-size: 30px">강의명
					: ${vo.cName}</div>
				<div class="fl-r bkg h100" style="width: 14%;">
					<div class="bor-ra bor-s w80 h30"
						style="margin: 34px 14px; line-height: 30px">참가비 :
						${vo.cMoney}원</div>
				</div>
			</div>
		</div>
		<!-- ////////////////////////// -->

		<!-- ============================================================================================ -->

		<!-- 강의 이미지~Button까지 -->
		<div style="height: 400px; margin-top: 20px">

			<!-- 좌측 이미지 -->
			<div class="fl-l" style="width: 49%">
				<div class="slider ali-c" style="height: 340px; line-height: 340px;">
					<div class="bkg h100 bor-s">이미지1</div>
					<div class="bkg h100 bor-s">이미지2</div>
					<div class="bkg h100 bor-s">이미지3</div>
				</div>
			</div>
			<!-- /////// -->

			<!-- 우측 이것저것 -->
			<div class="h100 fl-r ali-c" style="width: 48%">
				<div class="w100" style="height: 15%">
					<div class="h70 fl-l bor-s line-h40" style="width: 48%;">참가인원
						: 0 / ${vo.cMaxPerson }명</div>
					<div class="h70 fl-r bor-s line-h40" style="width: 48%;">
						강의 시작일 :
						<fmt:formatDate value="${vo.cDate}" pattern="yyyy년 MM월 dd일 HH시" />
					</div>
				</div>
				<div class="w100" style="height: 24%; line-height: 30px">
					<div class="w20 h30 bkg fl-l bor-s bor-ra" style="">카테고리</div>
					<div class="w20 h30 bkg fl-l bor-s bor-ra"
						style="margin-left: 30px">카테고리</div>
					<div class="w20 h30 bkg fl-l bor-s bor-ra"
						style="margin-left: 30px">카테고리</div>
					<div class="w20 h30 bkg fl-l bor-s bor-ra"
						style="margin-left: 30px">카테고리</div>
					<div class="w20 h30 bkg fl-l bor-s bor-ra" style="margin-top: 20px">카테고리</div>
					<div class="w20 h30 bkg fl-l bor-s bor-ra"
						style="margin-left: 30px; margin-top: 20px">카테고리</div>
					<div class="w20 h30 bkg fl-l bor-s bor-ra"
						style="margin-left: 30px; margin-top: 20px">카테고리</div>
					<div class="w20 h30 bkg fl-l bor-s bor-ra"
						style="margin-left: 30px; margin-top: 20px">카테고리</div>
				</div>
				<div class="w100 bkg h40" style="line-height: 160px">${vo.cSummary }</div>
				<div class="w100 h20" style="line-height: 80px">
					<input type="button" onclick="pay()" value="참가하기" id="join" class="w60 h80"
						style="border-radius: 5px; margin-top: 20px">
				</div>
			</div>
			<!-- ///////// -->

		</div>
		<!-- ///////////////// -->
		<!-- ============================================================================================ -->

		<!-- 상세,참가자,Comment 리스트(가로) -->
		<div style="margin-top: 20px">
			<div class="ali-c bor-s line-h40" style="height: 40px;">
				<div id="l1" class="w10 h100 fl-l bor-ri dis-block"
					style="height: 40px;">상세</div>
				<div id="l2" class="w10 h100 fl-l bor-ri dis-block"
					style="height: 40px;">참가자</div>
				<div id="l3" class="w10 h100 fl-l bor-ri dis-block"
					style="height: 40px;">Comment</div>
			</div>
		</div>
		<!-- /////////////////////////// -->

		<!-- ============================================================================================ -->

		<!-- 리스트에 대한 강의 상세정보(강사소개,강의 상세소개,강의장소,주의사항) -->
		<div id="infodetail" class="" style="">

			<!-- 강사소개 -->
			<div class="bor-s" style="height: 500px;">
				&nbsp;
				<div class="" style="font-size: 30px;">&nbsp;강사소개</div>
				<div>
					<div class="fl-l bor-s ali-c"
						style="width: 80px; height: 80px; border-radius: 100px; line-height: 80px; margin: 20px; margin-left: 40px">프로필사진</div>
					<div class="fl-l bor-s ali-c"
						style="width: 100px; margin-top: 20px">${memvo.memNickname }</div>
				</div>
				<div class="h60 w60 bor-s clear-b ali-c"
					style="margin-left: 40px; line-height: 300px">${memvo.memIntro}</div>
			</div>
			<!-- ------ -->

			<!-- 강의 상세소개 -->
			<div class="bor-s" style="height: 500px;">
				&nbsp;
				<div class="" style="font-size: 30px;">&nbsp;강의 상세소개</div>
				<div class="h70 w60 bor-s ali-c"
					style="margin: 40px 0 0 40px; line-height: 350px">${vo.cDetail }</div>
			</div>
			<!-- --------- -->

			<input id="maplocation" type="hidden" value="경기 안양시 동안구 관악대로106번길 72">
			<!--지도에 넣을 값을 슬쩍 넣어줄 곳 -->

			<!-- 강의 장소 -->
			<div class="bor-s" style="height: 600px;">
				&nbsp;
				<div class="" style="font-size: 30px;">&nbsp;강의 장소</div>
				<div class="h70 w90 bor-s ali-c"
					style="margin: 30px auto; line-height: 420px">
					<div id="map" style="width: 100%; height: 100%;"></div>

					<script type="text/javascript"
						src="//dapi.kakao.com/v2/maps/sdk.js?appkey=baf5b9ccc0421b2e1e36a0342486e30b&libraries=services"></script>
					<script>
						var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
						mapOption = {
							center : new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
							level : 3
						// 지도의 확대 레벨
						};

						// 지도를 생성합니다    
						var map = new daum.maps.Map(mapContainer, mapOption);

						// 주소-좌표 변환 객체를 생성합니다
						var geocoder = new daum.maps.services.Geocoder();

						//주소를 가져온다
						var maplocation = $("#maplocation").val();

						// 주소로 좌표를 검색합니다
						geocoder
								.addressSearch(
										maplocation,
										function(result, status) {
											//address 주소 입력하면 될듯!!
											// 정상적으로 검색이 완료됐으면 
											if (status === daum.maps.services.Status.OK) {

												var coords = new daum.maps.LatLng(
														result[0].y,
														result[0].x);

												// 결과값으로 받은 위치를 마커로 표시합니다
												var marker = new daum.maps.Marker(
														{
															map : map,
															position : coords
														});
												var ka = coords;

												// 마커가 드래그 가능하도록 설정합니다 
												marker.setDraggable(true);

												var iwContent = '<div style="text-align:left;font-size:12px;width:200px; height:50px; line-height:30px;">모임장소<br><a href="http://map.daum.net/link/map/hell,'+result[0].y+','+result[0].x+'" style="color:blue" target="_blank">큰지도보기</a> <a href="http://map.daum.net/link/to/hell,'+result[0].y+','+result[0].x+'" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
												iwPosition = new daum.maps.LatLng(
														33.450701, 126.570667); //인포윈도우 표시 위치입니다

												// 인포윈도우를 생성합니다
												var infowindow = new daum.maps.InfoWindow(
														{
															position : iwPosition,
															content : iwContent
														});

												// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
												infowindow.open(map, marker);

												// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
												map.setCenter(coords);
											}
										});
					</script>

				</div>
				<div class="w90 bor-s ali-c line-h40"
					style="height: 40px; margin: 0 auto;">${vo.cLocation }</div>
			</div>
			<!-- ------ -->

			<!-- 주의사항 -->
			<div class="bor-s" style="height: 400px;">
				&nbsp;
				<div class="" style="font-size: 30px;">&nbsp;주의사항</div>
				<div class="h70 w50 bor-s ali-c"
					style="margin: 40px 0 20px 40px; line-height: 280px">주의사항
					TEXT</div>
			</div>
			<!-- ------ -->

		</div>
		<!-- ////////////////////상세끝////////////////////////// -->

		<!-- ============================================================================================ -->

		<!-- 참가자(프로필 리스트) -->
		<div id="profilelist" class="bor-s " style="height: 400px;">
			<div class="">
				<div class="fl-l w40 bor-s"
					style="height: 130px; margin: 40px 0 0 40px">
					<div class="fl-l bor-s ali-c"
						style="width: 80px; height: 80px; margin: 10px; border-radius: 100px; line-height: 80px">사진</div>
					<div class="fl-l ali-c">
						<div class="bor-s"
							style="width: 150px; margin-top: 10px; height: 30px">유저명</div>
						<div>
							<div class="fl-l bor-s"
								style="width: 100px; margin-top: 10px; height: 30px">포지션</div>
							<div class="fl-l bor-s"
								style="width: 100px; margin: 10px 0 0 10px; height: 30px">포지션</div>
						</div>
						<div class="bor-s clear-b"
							style="width: 300px; margin-top: 49px; height: 30px">관심
							카테고리</div>
					</div>
				</div>
				<div class="fl-l w40 bor-s"
					style="height: 130px; margin: 40px 0 0 40px">
					<div class="fl-l bor-s ali-c"
						style="width: 80px; height: 80px; margin: 10px; border-radius: 100px; line-height: 80px">사진</div>
					<div class="fl-l ali-c">
						<div class="bor-s"
							style="width: 150px; margin-top: 10px; height: 30px">유저명</div>
						<div>
							<div class="fl-l bor-s"
								style="width: 100px; margin-top: 10px; height: 30px">포지션</div>
							<div class="fl-l bor-s"
								style="width: 100px; margin: 10px 0 0 10px; height: 30px">포지션</div>
						</div>
						<div class="bor-s clear-b"
							style="width: 300px; margin-top: 49px; height: 30px">관심
							카테고리</div>
					</div>
				</div>
				<div class="fl-l w40 bor-s"
					style="height: 130px; margin: 40px 0 0 40px">
					<div class="fl-l bor-s ali-c"
						style="width: 80px; height: 80px; margin: 10px; border-radius: 100px; line-height: 80px">사진</div>
					<div class="fl-l ali-c">
						<div class="bor-s"
							style="width: 150px; margin-top: 10px; height: 30px">유저명</div>
						<div>
							<div class="fl-l bor-s"
								style="width: 100px; margin-top: 10px; height: 30px">포지션</div>
							<div class="fl-l bor-s"
								style="width: 100px; margin: 10px 0 0 10px; height: 30px">포지션</div>
						</div>
						<div class="bor-s clear-b"
							style="width: 300px; margin-top: 49px; height: 30px">관심
							카테고리</div>
					</div>
				</div>
				<div class="fl-l w40 bor-s"
					style="height: 130px; margin: 40px 0 0 40px">
					<div class="fl-l bor-s ali-c"
						style="width: 80px; height: 80px; margin: 10px; border-radius: 100px; line-height: 80px">사진</div>
					<div class="fl-l ali-c">
						<div class="bor-s"
							style="width: 150px; margin-top: 10px; height: 30px">유저명</div>
						<div>
							<div class="fl-l bor-s"
								style="width: 100px; margin-top: 10px; height: 30px">포지션</div>
							<div class="fl-l bor-s"
								style="width: 100px; margin: 10px 0 0 10px; height: 30px">포지션</div>
						</div>
						<div class="bor-s clear-b"
							style="width: 300px; margin-top: 49px; height: 30px">관심
							카테고리</div>
					</div>
				</div>

			</div>
		</div>
		<!-- //////////////// -->

		<!-- ============================================================================================ -->

		<!-- Comment Write, Comment List -->
		<div id="comment" class="bor-s">

			<div class="" style="height: 200px;">
				<div class="w70" style="margin-left: 40px">
					<form name="" method="post" action="#">
						<textarea class="w100 fl-r"
							style="height: 100px; font-size: 20px; margin-top: 20px"
							placeholder="댓글을 입력하세요"></textarea>
						<input class="fl-r" type="submit" value="댓글 달기"
							style="height: 65px; width: 100px">
					</form>
				</div>
			</div>

			<div class="w70 ali-c" style="height: 200px; margin-left: 40px">
				<div class="fl-l bor-s"
					style="width: 80px; height: 80px; line-height: 80px; border-radius: 100px; margin: 10px">이미지</div>
				<div class="fl-r" style="width: 600px">
					<div style="margin-top: 10px">
						<div class="fl-l bor-s bor-ra" style="height: 30px; width: 150px;">유저명</div>
						<div class="fl-r bor-s bor-ra" style="height: 30px; width: 150px;">등록시간</div>
					</div>
					<div class="clear-b bor-s"
						style="height: 120px; line-height: 100px; margin-top: 50px">
						<p>댓글 메시지</p>
					</div>
					<div>
						<a class="fl-r" href="#">답글달기</a>
					</div>
				</div>
			</div>

			<div class="" style="height: 200px">
				<div class="w70" style="margin-left: 40px">
					<form name="" method="post" action="#">
						<textarea class="w90 fl-r"
							style="height: 100px; font-size: 20px; margin-top: 20px"
							placeholder="댓글을 입력하세요"></textarea>
						<input class="fl-r" type="submit" value="댓글 달기"
							style="height: 65px; width: 100px">
					</form>
				</div>
			</div>

			<div class="w70 ali-c" style="height: 200px; margin-left: 40px">
				<div class="fl-l bor-s"
					style="width: 80px; height: 80px; line-height: 80px; border-radius: 100px; margin: 10px">이미지</div>
				<div class="fl-r" style="width: 600px">
					<div style="margin-top: 10px">
						<div class="fl-l bor-s bor-ra" style="height: 30px; width: 150px;">유저명</div>
						<div class="fl-r bor-s bor-ra" style="height: 30px; width: 150px;">등록시간</div>
					</div>
					<div class="clear-b bor-s"
						style="height: 120px; line-height: 100px; margin-top: 50px">
						<p>댓글 메시지</p>
					</div>
					<div>
						<a class="fl-r" href="#">답글달기</a>
					</div>
				</div>
			</div>

			<div class="w70 ali-c" style="height: 200px; margin-left: 40px">
				<div class="fl-r" style="width: 500px">
					<div style="margin-top: 10px">
						<div class="fl-l bor-s bor-ra" style="height: 30px; width: 150px;">유저명</div>
						<div class="fl-r bor-s bor-ra" style="height: 30px; width: 150px;">등록시간</div>
					</div>
					<div class="clear-b bor-s"
						style="height: 120px; line-height: 100px; margin-top: 50px">
						<p>댓글 메시지</p>
					</div>
				</div>
				<div class="fl-r bor-s"
					style="width: 80px; height: 80px; line-height: 80px; border-radius: 100px; margin: 10px">이미지</div>
			</div>

			<div class="w70 ali-c" style="height: 200px; margin-left: 40px">
				<div class="fl-r" style="width: 500px">
					<div style="margin-top: 10px">
						<div class="fl-l bor-s bor-ra" style="height: 30px; width: 150px;">유저명</div>
						<div class="fl-r bor-s bor-ra" style="height: 30px; width: 150px;">등록시간</div>
					</div>
					<div class="clear-b bor-s"
						style="height: 120px; line-height: 100px; margin-top: 50px">
						<p>댓글 메시지</p>
					</div>
				</div>
				<div class="fl-r bor-s"
					style="width: 80px; height: 80px; line-height: 80px; border-radius: 100px; margin: 10px">이미지</div>
			</div>

		</div>
		<!-- /////////////////////////// -->

		<!-- ============================================================================================ -->
	</div>

	<%@ include file="../inc/footer.jsp"%>