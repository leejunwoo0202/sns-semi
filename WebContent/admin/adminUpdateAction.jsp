<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.DTO.*" %>
    <% 
        AdminDTO dto = (AdminDTO)request.getAttribute("admin");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form action="adminUpdateProAction.6" name="frm" id="frm" method="post">
   <input type="hidden" name="adminId" value="<%= dto.getAdminId() %>"/>
   <table width="600" align="center" border="1">
   
   <caption>회원정보 관리</caption>
      <colgroup>
      <col width="200">
      <col width="400">
      </colgroup>
      <tbody>
      <tr><td>사용자 ID : </td><td><%= dto.getAdminId() %></td></tr>
      <tr><td>전화번호 : </td><td><%= dto.getAdminTel() %></td></tr>
      <tr><td>성별 : </td><td><%= dto.getAdminGender() %></td></tr>
      <tr><td colspan="2"></td></tr>
      
      <tr><td>새 비밀번호 :</td><td><input type="password" name="adminPassword"></td></tr>
      <tr><td>새 전화번호 :</td><td><input type="tel" name="adminTel"></td></tr>
      </tbody>
      
      <tfoot>
         <tr><td><input type="submit" value="수정하기"></td></tr>
         
      </tfoot>
   </table>

</form>
</body>
</html>