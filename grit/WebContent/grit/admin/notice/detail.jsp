<%@page import="java.sql.SQLException"%>
<%@page import="com.grit.notice.model.NoticeDAO"%>
<%@page import="com.grit.notice.model.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail.jsp</title>
<style type="text/css">
	body{
		padding:5px;
		margin:5px;
	 }
	.divForm {
		width: 500px;
		}
</style>  
</head>
<body>
	<h2>공지사항</h2>
	<div class="divForm">
		<div class="firstDiv">
			<span class="sp1">번호</span> <span>${vo.notiNo}</span>
		</div>
		<div>
			<span class="sp1">제목</span> <span>${vo.notiTitle}</span>
		</div>
		<div>
			<span class="sp1">등록일</span> <span>${vo.notiRegdate}</span>
		</div>
		<div>
			<span class="sp1">등록자</span> <span>${vo.adminId}</span>
		</div>
		<div>
			<span class="sp1">상태</span> <span>${vo.notiDelflag}</span>
		</div>
		<div class="lastDiv">			
			<p class="content">${vo.notiContent}</p>
		</div>
		<div class="center">
			<a>수정</a> |
        	<a>삭제</a> |
        	<a href='<c:url value="/grit/admin/notice/list.do"/>'>목록</a>			
		</div>
	</div>
</body>
</html>