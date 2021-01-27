<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.DTO.BoardDTO"%>
<%
	BoardDTO dto = (BoardDTO) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="boardModifyPro.4" method="post" name="frm">
		<input type="hidden" name="boardNum" value="<%=dto.getBoardNum()%>" />
		<table border="1">
			<tr>
				<td>글쓴이</td>
				<td><%=dto.getBoardWriter()%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="boardSubject"
					value="<%=dto.getBoardSubject()%>" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="30" name="boardContent"><%=dto.getBoardContent()%></textarea>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="boardPw" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="전송"></td>
			</tr>

		</table>
	</form>
</body>
</html>