<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<style>
#tableMenu .row:hover {
	background-color: beige;
}
</style>
<script type="text/javascript">

function formSubmit(str) {
	frm.bId.value=str;
	frm.submit();
}

</script>
<body>
<div align="center">
		<h1>게시글 목록</h1>
		<div>
			<form id="frm" name="frm" action="boardView.do" method="post">
				<input type="hidden" id="bId" name="bId">
			</form>
			<table border="1" id="tableMenu">
				<tr>
					<th width="100">글번호</th>
					<th width="200">제 목</th>
					<th width="100">작성자</th>
					<th width="100">작성일</th>
					<th width="200">글내용</th>
					<th width="50">조회수</th>
				</tr>
				<c:choose>
					<c:when test="${not empty list}" >
						<c:forEach var="vo" items="${list }">
						<tr class="row" onclick="formSubmit(${vo.bId })">
								<td align="center">${vo.bId }</td>
								<td>&nbsp;${vo.bTitle }</td>
								<td align="center">${vo.bName }</td>
								<td align="center">${vo.bDate }</td>
								<td align="center">${vo.bContent }</td>
								<td align="center">${vo.bHit }</td>
							</tr>
						</c:forEach>						
					</c:when>
				</c:choose>
			</table>
		</div><br />
		<div>
		<button type="button" onclick="location.href='boardInsertForm.do'">새글쓰기</button>
		</div>
	</div>
</body>
</html>