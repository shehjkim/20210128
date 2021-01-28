<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<script type="text/javascript"> 
	function deleteAlert(){
		var yn = confirm("정말 삭제할까요?");
		if(yn) {
			frm.action="boardDelete.do";
			frm.submit();
		}else{
			
		}
		
	}
	function editAlert(){
		frm.action="boardEditForm.do";
		frm.submit();
	}

</script>
</head>
<body>
	<div align="center">
		<h1>글 상세보기</h1>
		<div>
			<form id="frm" name="frm" action="" method="post">
				<div>
					<br />
					<table border="1">
						<tr>
							<th width="150">글번호</th>
							<td align="center" width="50">
							<input type="text"id="bId" name="bId" value="${vo.bId }" readonly="readonly"></td>
							<th width="100">작성자</th>
							<td align="center" width="50">${vo.bName }</td>
							<th width="100">작성일자</th>
							<td align="center" width="100">${vo.bDate }</td>
							<th width="100">조회수</th>
							<td align="center" width="50">${vo.bHit }</td>
						</tr>
						<tr>
							<th width="60">제 목</th>
							<td colspan="7">${vo.bTitle }</td>
						</tr>
						<tr>
							<th width="50">내 용</th>
							<td colspan="7" height="300">${vo.bContent }</td>
						</tr>
					</table>
				</div>
				<br />
				<div>
					<button type="button" onclick="location.href='boardList.do'">목록보기</button>
					<button type="button" onclick="deleteAlert()">삭 제</button>
					<button type="button" onclick="editAlert()">수 정</button>
				</div>
			</form>
		</div>

	</div>

</body>
</html>