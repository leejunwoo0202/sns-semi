<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.DTO.*" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<!--  수정하러 가기전에 비밀번호를 확인하는 로직 -->
<form action="memberUpdateAction.5" method="post">
<table border="1">

   <tr><th>아이디 확인(필수):</th><td><input type="text" name="memberId"></td></tr>
   <tr><th>비밀번호 확인(필수):</th><td><input type="password" name="memberPassword"></td></tr>
   
   <tr><td><input type="submit" value="수정하러 가기"></td></tr>
   <tr><td><a href="main.1">메인화면으로 가기</a></td></tr>
   
</table>
</form>
</body>
</html>