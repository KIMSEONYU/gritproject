<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/adminTop.jsp" %>


<div class="content">
	<div style="width:50%; margin-left:25%;">
		<table style="width:100%; border:1px solid gray;" id="table1">
			<colgroup>
				<col style="width:5%;">
				<col style="width:55%;">
				<col style="width:15%;">
				<col style="width:15%;">
				<col style="width:10%;">
			</colgroup>
			<thead>
				<tr style="text-align:center; background-color:gray;">
					<th>번호</th>
					<th>공지사항 이름</th>
					<th>등록일자</th>
					<th>등록자</th>
					<th>상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${list }" >
					<tr style="text-align:center;">
						<td>${vo.notiNo}</td>
						<td>${vo.notiTitle }</td>
						<td>
							<fmt:formatDate value="${vo.notiRegdate }" pattern="yyyy-MM-dd E요일"/>
						</td>
						<td>${vo.adminId }</td>
						<td><label>상태</label></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="../inc/adminBottom.jsp" %>