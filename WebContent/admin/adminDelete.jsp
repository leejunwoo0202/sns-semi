<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원삭제</h2>
<form action="adminDeletePro.6" method="post">
  <table border="1">
     <tr><th>아이디 :</th><td><input type="text" name="adminId"></td></tr>
     <tr><th>비밀번호 :</th><td><input type="password" name="adminPassword"></td></tr>
     <tr><td><input type="submit" value="삭제">
             <a href="/talkToMe_semi/main/main.jsp">메인화면으로 가기</a></td></tr>
  
  </table>
</form>
</body>
</html>