<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.DTO.*" %>
<% 
    List list = (List)request.getAttribute("memberList");
    Integer count = (Integer)request.getAttribute("memberCount");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버리스트</title>
</head>
<body>
<h2 align="center">멤버리스트 페이지</h2>
<table border="1" align="center">
  <tr><td colspan="4">회원수</td><td><%=count %></td></tr>
  <tr><td>아이디</td><td>전화번호</td><td>성별</td></tr>
  <% for(int i =0; i<list.size(); i++){
	  MemberDTO dto = (MemberDTO)list.get(i);         
	  %>
	 
	 <tr><td><%= dto.getMemberId() %></td>
	 <td><%= dto.getMemberTel() %></td>
	 <td><%= dto.getMemberGender() %></td></tr>

  <%} %>

</table>
</body>
</html>