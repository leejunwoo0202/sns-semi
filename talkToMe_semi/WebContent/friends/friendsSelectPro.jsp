<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.DTO.*" %>
<% List list = (List)request.getAttribute("list");
   Integer count = (Integer)request.getAttribute("count");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">친구리스트 페이지</h2>
<table border="1" align="center">
   <tr><td colspan="4">친구수</td><td><%=count %></td></tr>
   <% for(int i=0; i<list.size(); i++){
	   FriendsDTO dto = (FriendsDTO)list.get(i);
	   %>
   
   
   <tr><td>친구</td><td><%=dto.getFriendsId()%>
       <td><a href="friendsInfo.2?friendsId=<%= dto.getFriendsId()%>">친구정보</a>
   </tr>
   
  <% } %>
  <a href="/talkToMe_semi/main.1">메인화면으로 가기</a>
</table>
</body>
</html>