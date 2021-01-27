<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.DTO.*" %>
<%
   List list = (List)request.getAttribute("groupList");
   Integer count = (Integer)request.getAttribute("groupCount");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H2 align="center">그룹리스트</H2>
<table border="1" align="center">
   <tr><td colspan="4">그룹수</td><td><%= count %></td></tr>
   <tr><td>그룹명</td><td>관리자</td><td>카테고리</td></tr>
   <% for(int i=0; i<list.size(); i++){
	   GroupDTO dto = (GroupDTO)list.get(i);
	   
	   %>
	   <tr><td><%= dto.getGroupName() %></td>
	       <td><%= dto.getGroupAdmin() %></td>
           <td><%= dto.getGroupKategorie() %></td></tr>    
  <%} %>

</table>
</body>
</html>