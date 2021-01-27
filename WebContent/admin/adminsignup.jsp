<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="adminsignupComplete.6" name="frm" id="frm" method="post">
<table border="1" align="center">
<div align="center"><h2>관리자 회원가입</h2></div>
<tr><th>아이디 :</th><td><input type="text" name="adminId"></td></tr>
<tr><th>비밀번호 :</th><td><input type="password" name="adminPassword"></td></tr>
<tr><th>비밀번호확인 :</th><td><input type="password" name="adminPassword1"></td></tr>
<tr><th>휴대폰번호 :</th><td><input type="tel" name="adminTel"></td></tr>
<tr><th>성별 :</th><td><input type="radio" name="adminGender" value="man">남자
                  <input type="radio" name="adminGender" value="woman">여자
</td></tr>

<tr><th><input type="submit" value="회원가입">
        <input type="reset" value="다시입력"></th>
  </tr>
</table>
</form>
</body>
</html>