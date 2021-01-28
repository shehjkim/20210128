<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
			<h1>게시글 작성</h1>

		<div>
			<form id="frm" name="frm" action="boardEditSave.do" method="post">
			<div><br />
				<table border="1">
					<tr>
						<th width="150">글번호</th>
						<td align="center" width="50">${vo.bId }</td>
						<th width="100">작성자</th>
						<td align="center" width="50">${vo.bName }</td>
						<th width="100">작성일자</th>
						<td align="center" width="50">${vo.bDate }</td>
					</tr>
					<tr>
						<th width="60">제목</th>
						<td colspan="5">${vo.bTitle }</td>
					</tr>
					<tr>
						<th width="50">내용</th>
						<td colspan="5"><textarea id="bContent" name="bContent" rows="30" cols="100" required="required">${vo.bContent }</textarea></td>
					</tr>
				</table>
		</div><br />
			<button type="submit">등록</button>
			<button type="reset" >취소</button>
	</form>
	</div>
</div>
</body>
</html>