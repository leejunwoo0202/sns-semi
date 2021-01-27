<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.DTO.*" %>
    <%
    MemberDTO dto =(MemberDTO)request.getAttribute("member");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function del(){
	location.href="memberDelPw.5?memberId=<%=dto.getMemberId()%>";
}
</script>
</head>
<body>
<form action="memberUpdateProAction.5"  name="frm" id="frm" method="post">
<input type="hidden" name="memberId" value="<%= dto.getMemberId() %>"/>
<table width="600" align="center" border="1">
<!--  비밀번호를 수정하거나 삭제하는 로직 --> 
  <caption>회원정보 관리</caption>
     <colgroup>
       <col width="200">
       <col width="400">
       </colgroup>
       <tbody>
       <tr><td>사용자 ID :</td><td><%= dto.getMemberId() %></td></tr>
       <tr><td>전화번호 :</td><td><%= dto.getMemberTel() %></td></tr>
       <tr><td>성별 :</td><td><%= dto.getMemberGender() %></td></tr>
       <tr><td colspan="2"></td></tr>
      
       <tr><td>새 비밀번호 :</td><td><input type="password" name="memberPassword"></td></tr>
       <tr><td>새 전화번호 :</td><td><input type="tel" name="memberTel"></td></tr>
       
       </tbody>
       
       <tfoot>
         <tr><td><input type="submit" value="수정하기"></td></tr>
         <tr><td><input type="button" value="삭제" onclick="del()"></td></tr>
       </tfoot>
       
</table>
</form>
</body>
</html>