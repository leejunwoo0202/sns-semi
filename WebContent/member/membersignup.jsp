<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>                    
</head>

<body>                         
        
<form action="membersignupComplete.5" name="frm" id="frm" method="post">
<table border="1" align="center">
<div align="center"><h2>회원가입</h2></div>
<tr><th>아이디 :</th><td><input type="text" name="memberId"></td></tr>
<tr><th>비밀번호 :</th><td><input type="password" name="memberPassword"></td></tr>
<tr><th>비밀번호확인 :</th><td><input type="password" name="password1"></td></tr>
<tr><th>휴대폰번호 :</th><td><input type="tel" name="memberTel" ></td></tr>
<tr><th>성별 :</th><td><input type="radio" name="memberGender" value="man" checked="checked">남자
                      <input type="radio" name="memberGender" value="woman">여자</td></tr>


<tr><th><input type="submit" value="회원가입">
        <input type="reset" value="다시입력"></th>
</tr>

</table>
</form>
</body>
</html>