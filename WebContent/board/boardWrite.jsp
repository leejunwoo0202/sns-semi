<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 메인화면</title>
</head>
<body>

<h2 align="center">글쓰기 메인화면</h2>
<form action="boardWritePro.4" method="post">
<table  border = "1">
	<tr><td>글쓴이</td>
		<td><input type="text" name="boardWriter"> </td></tr>
	<tr><td>제목</td>	
		<td><input type="text" name="boardSubject"></td></tr>
	<tr><td>내용</td>
		<td><textarea rows="20" cols="30" name="boardContent"></textarea></td></tr>
	<tr><td>비밀번호</td>
		<td><input type="password" name="boardPw"></td></tr>
	<tr><td colspan="2">
			<input  type="submit" value="저장">
			<input type="reset" value="다시 작성">
		</td></tr>
</table>
</form>
</body>
</html>