<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.DTO.AdminDTO" %>
<%
    List adminList = (List)request.getAttribute("adminList");
    Integer adminCount = (Integer)request.getAttribute("adminCount");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">멤버리스트 페이지</h2>
<table border="1" align="center">
 <tr><td colspan="4">회원수</td><td><%= adminCount %></td></tr>
 <tr><td>아이디</td><td>전화번호</td><td>성별</td></tr>
   <% for(int i=0; i < adminList.size(); i++){
	   AdminDTO dto = (AdminDTO)adminList.get(i);
	   %>
	   <tr><td><%= dto.getAdminId() %></td>
	   <td><%= dto.getAdminTel() %></td>
	   <td><%= dto.getAdminGender() %></td></tr>
   <% } %>
 
</table>
</body>
</html>