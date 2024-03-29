<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="inc/header.jsp"%>
<%@ include file="login/login.jsp"%>
<style>
* {
	padding: 0;
	margin: 0;
}

body {
	font-size: 12px;
	font-family: "나눔바른고딕", dotum, sans-serif;
	color: #333;
}

.contents {
	width: 1024px;
	min-width: 1024px;
	height: 400px;
	margin: 0 auto;
	margin-top: 40px;
}

.contents .contents1 {
	width: 55%;
	height: 385px;
	border-right: 0.2px solid gray;
	float: left;
}

.contents .contents2 {
	width: 45%;
	height: 390px;
	float: left;
}

.infobox1 {
	margin: 10px 0 0 30px;
	width: 400px;
	height: 100px;
}

.infobox2 {
	margin: 15px 0 0 30px;
	width: 400px;
	height: 100px;
}

.infobox3 {
	margin: 15px 0 0 30px;
	width: 400px;
	height: 100px;
}

.infoboxtable {
	width: 290px;
	margin: 0 0 0 10px;
	text-align: center;
}

.box70 {
	width: 70%;
	border: 1px solid black;
	height: 25px;
}

.box30 {
	width: 30%;
	border: 1px solid black;
	height: 25px;
}

.leli {
	background-color:gray;
	float: left;
	height: 100px;
	width: 100px;
	border:1px solid black;
}

.rili {
	float: right;
	height: 100px;
	width: 300px;
}

.dotnone {
	list-style: none;
}

.imgbox1 {
	margin: 10px auto;
	width: 500px;
	height: 200px;
	background-image: url("img/img1.png");
	border: 1px solid black;
}

.joinfee {
	width: 80px;
	height: 30px;
	background-color: black;
	border-radius: 5px;
	border: 1px solid black;
	color: white;
	float: right;
	margin: 160px 10px 0 0;
}

.joinfee1 {
	width: 80px;
	height: 30px;
	background-color: black;
	border-radius: 5px;
	border: 1px solid black;
	color: white;
	position: absolute;
	margin: 43% 0 0 68%;
}

.cardtable {
	border: 1px solid black;
	text-align: center;
	height: 110px;
	width: 100%;
}

#joinbtn {
	width: 100%;
	height: 30px;
	background-color: black;
	color: white;
	border: 1px solid black;s
	border-radius: 5px;
}
.lecturebtn{
	width:85px;
	height:40px;
	position:absolute;
	right:19%;
	font-size:12px;
	line-height:12px;
	position: fixed;
	background-color: #02340f;
	border:1px solid #02340f;
	color:white;
	margin-top:90px;
}
.advertisement{
	width:85px;
	height:120px;
	position:absolute;
	right:19%;
	position: fixed;
	/*border:1px solid #02340f;*/
	margin-top:140px;
	background-image: url('img/event.png');
}
</style>
<body>

	<!-- Navigation -->
	
	<header>
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<!-- Slide One - Set the background image for this slide in the line below -->
				<div class="carousel-item active"
					style="background-image: url('img/banner1.png');">

					<!--<div class="carousel-caption d-none d-md-block">
               국내 유일 스타트업 네트워크 STAR-IT에 오신 것을 환영합니다</h3>
              <p>더 나아지는 자신을 만들고 싶다면<br>
              스터디로 역량을 쌓고 팀빌딩과 네트워킹에서 각 분야의 전문가들을 만나보세요</p> 
            </div>-->
				</div>
				<!-- Slide Two - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('img/banner1.png');">
					<!-- <div class="carousel-caption d-none d-md-block">
              <h3>Second Slide</h3>
              <p>This is a description for the second slide.</p>
            </div> -->
				</div>
				<!-- Slide Three - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('img/banner1.png');">
					<!--  <div class="carousel-caption d-none d-md-block">
              <h3>Third Slide</h3>
              <p>This is a description for the third slide.</p>
            </div>-->
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</header>
	<!-- Page Content -->
	
	
	<input class="lecturebtn" type="button" onclick="location.href='<c:url value="/grit/lecture/lectureRegister.do"/>'" value="모임개설하기">
	<div class="advertisement"></div>
	
	<ul class="contents" style="list-style: none">
		<li class="contents1">
			<div>
				<div
					style="margin: 20px 0 0 40px; font-size: 14px; text-align: left; font-wegiht:bold;">실시간
					인기 모임</div>
				<div class="imgbox1">
					<input type="button" value="참가비" class="joinfee">
				</div>
			</div>
			<div>
				<table border="1"
					style="width: 500px; margin: auto; text-align: center">
					<thead>
						<tr>
							<td colspan="3" style="height: 25px;">강의 명</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="width: 60%; height: 25px;">카테고리</td>
							<td style="width: 20%; height: 25px;">남은 자리</td>
							<td style="width: 20%; height: 25px;">D-day</td>
						</tr>
					</tbody>
					<tfoot>
						<tr style="height: 70px">
							<td colspan="3">강의 요약설명</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</li>
		<li class="contents2">
			<div style="margin: 20px 0 0 40px; font-size: 14px;">추천 모임</div>
			<!-- 반복시작 -->
			<div class="infobox1">
				<ul class="dotnone">
					<li class="leli"></li>
					<li class="rili">
						<table border="1" class="infoboxtable">
							<thead>
								<tr>
									<td colspan="2" style="height: 40px; line-height: 40px;">강의명</td>
								</tr>
							</thead>
							<tbody>
								<tr style="height: 30px;">
									<td class="box30">남은 자리</td>
									<td class="box70">D-day</td>
								</tr>
							</tbody>
							<tfoot>
								<tr style="height: 30px;">
									<td class="box70">카테고리</td>
									<td class="box30"><input type="button" value="참가비"
										id="joinbtn"></td>
								</tr>
							</tfoot>
						</table>
					</li>
				</ul>
			</div>
			<!-- 반복끝 -->
			<div class="infobox2">
				<ul class="dotnone">
					<li class="leli"></li>
					<li class="rili">
						<table border="1" class="infoboxtable">
							<thead>
								<tr>
									<td colspan="2" style="height: 40px; line-height: 40px;">강의명</td>
								</tr>
							</thead>
							<tbody>
								<tr style="height: 30px;">
									<td class="box30">남은 자리</td>
									<td class="box70">D-day</td>
								</tr>
							</tbody>
							<tfoot>
								<tr style="height: 30px;">
									<td class="box70">카테고리</td>
									<td class="box30"><input type="button" value="참가비"
										id="joinbtn"></td>
								</tr>
							</tfoot>
						</table>
					</li>
				</ul>
			</div>
			<div class="infobox3">
				<ul class="dotnone">
					<li class="leli"></li>
					<li class="rili">
						<table border="1" class="infoboxtable">
							<thead>
								<tr>
									<td colspan="2" style="height: 40px; line-height: 40px;">강의명</td>
								</tr>
							</thead>
							<tbody>
								<tr style="height: 30px;">
									<td class="box30">남은 자리</td>
									<td class="box70">D-day</td>
								</tr>
							</tbody>
							<tfoot>
								<tr style="height: 30px;">
									<td class="box70">카테고리</td>
									<td class="box30"><input type="button" value="참가비" id="joinbtn"></td>
								</tr>
							</tfoot>
						</table>
					</li>
				</ul>
			</div>
		</li>
	</ul>
	<!-- Portfolio Section -->
	<!--<h2>현재 진행중인 강의</h2>-->
	<div class="container" style="margin-top: 20px; width: 990px;">
		<div class="row">
			<!-- 반복시작 -->
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card">

					<div style="position: relative; height: 170px;">
						<input type="button" value="참가비" class="joinfee1">
						<a href="#">
							<img class="card-img-top" src="http://placehold.it/700x400" alt=""> 
						</a>
					</div>

					<div class="card-body" style="height: 150px;">
						<table class="cardtable">

							<tr>
								<td colspan="2">강의 명</td>
							</tr>

							<tr>
								<td class="box30">남은 자리</td>
								<td class="box70">D-day</td>
							</tr>

							<tr>
								<td colspan="2">카테고리</td>
							</tr>
						</table>

					</div>
				</div>
			</div>
			<!-- 반복끝 -->
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card">
					<div style="position: relative; height: 170px;">
						<input type="button" value="참가비" class="joinfee1">
						<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""> 
						</a>
					</div>
					<div class="card-body" style="height: 150px;">
						<table class="cardtable">
							<tr>
								<td colspan="2">강의 명</td>
							</tr>

							<tr>
								<td class="box30">남은 자리</td>
								<td class="box70">D-day</td>
							</tr>

							<tr>
								<td colspan="2">카테고리</td>
							</tr>
						</table>

					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card">
					<div style="position: relative; height: 170px;">
						<input type="button" value="참가비" class="joinfee1">
						<a href="#">
							<img class="card-img-top" src="http://placehold.it/700x400" alt=""> 
						</a>
					</div>
					<div class="card-body" style="height: 150px;">
						<table class="cardtable">
							<tr>
								<td colspan="2">강의 명</td>
							</tr>

							<tr>
								<td class="box30">남은 자리</td>
								<td class="box70">D-day</td>
							</tr>

							<tr>
								<td colspan="2">카테고리</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card">
					<div style="position: relative; height: 170px;">
						<input type="button" value="참가비" class="joinfee1">
						<a href="#">
							<img class="card-img-top" src="http://placehold.it/700x400" alt=""> 
						</a>
					</div>
					<div class="card-body" style="height: 150px;">
						<table class="cardtable">

							<tr>
								<td colspan="2">강의 명</td>
							</tr>

							<tr>
								<td class="box30">남은 자리</td>
								<td class="box70">D-day</td>
							</tr>

							<tr>
								<td colspan="2">카테고리</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card">
					<div style="position: relative; height: 170px;">
						<input type="button" value="참가비" class="joinfee1">
						<a href="#">
							<img class="card-img-top" src="http://placehold.it/700x400" alt=""> 
						</a>
					</div>
					<div class="card-body" style="height: 150px;">
						<table class="cardtable">
							<tr>
								<td colspan="2">강의 명</td>
							</tr>
							<tr>
								<td class="box30">남은 자리</td>
								<td class="box70">D-day</td>
							</tr>

							<tr>
								<td colspan="2">카테고리</td>
							</tr>
						</table>

					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card">
					<div style="position: relative; height: 170px;">
						<input type="button" value="참가비" class="joinfee1">
						<a href="#">
							<img class="card-img-top" src="http://placehold.it/700x400" alt=""> 
						</a>
					</div>
					<div class="card-body" style="height: 150px;">
						<table class="cardtable">
							<tr>
								<td colspan="2">강의 명</td>
							</tr>
							<tr>
								<td class="box30">남은 자리</td>
								<td class="box70">D-day</td>
							</tr>
							<tr>
								<td colspan="2">카테고리</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- /row -->

	</div>
	<!-- /.container -->
	<%@ include file="inc/footer.jsp"%>