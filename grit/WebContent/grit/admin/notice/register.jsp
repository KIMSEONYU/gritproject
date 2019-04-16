<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/adminTop.jsp" %>
<div class="content">
<form class="registerbox" name="frmNotice" method="post" action="<c:url value='/grit/admin/notice/register_ok.do'/>">
	<div class="notice_add">공지사항 추가</div>
	<select name="noti_category">
		<option>강의</option>
		<option>채용</option>
		<option>팀빌딩</option>
		<option>네트워킹</option>
	</select>
	<input name="noti_title" type="text" class="notice_title" placeholder="여기에 공지사항 제목을 입력하세요">
	<textarea name="noti_content" class="notice_contents" placeholder="여기에 공지사항 본문을 입력하세요"></textarea>
	<input type="submit" value="추가" >
	<input type="reset" value="취소">
</form>
</div>
<%@ include file="../inc/adminBottom.jsp" %>