<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹추가</title>
</head>
<body>
<h2>그룹추가</h2>
<form action="groupInsertPro.3" enctype="multipart/form-data" method="post">
  <table border="1" align="center">
    <tr><th>그룹이름 :</th><td><input type="text" name="groupName"></td></tr>
    <tr><th>그룹관리자 :</th><td><input type="text" name="groupAdmin"></td></tr>
    <tr><th>카테고리 :</th><td><input type="text" name="groupKategorie"></td></tr>
    <tr><th>사진 :</th><td><input type="file" name="fileName"></td></tr>
    <tr><th><input type="submit" value="그룹만들기"></th>
        <th><input type="reset" value="다시 쓰기"></th></tr>
    
  </table>
</form>
</body>
</html>