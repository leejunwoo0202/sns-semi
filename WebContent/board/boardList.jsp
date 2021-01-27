<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.DTO.*" %>
<%
   List list = (List)request.getAttribute("boardList");
   Integer count = (Integer)request.getAttribute("boardCount");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 리스트입니다</h2><br>
<a href="boardWrite.4">게시글 쓰기</a>
<table border="1">
         <tr><td colspan="3">게시글 리스트</td>
             <td>게시글 수 : <%=count %></td></tr>
             
         <tr><td>게시글 번호</td><td>제목</td><td>글쓴이</td><td>방문자수</td></tr>
         <% for(int i =0; i<list.size(); i++){
        	 BoardDTO dto = (BoardDTO)list.get(i);
        	 %>
         <tr><td><a href="boardDetail.4?boardNum=<%= dto.getBoardNum() %>">
             <%= dto.getBoardNum() %></a></td>
             <td><a href="boardDetail.4?boardNum=<%= dto.getBoardNum() %>">
                 <%= dto.getBoardSubject() %></a></td> 	 
        	 <td><%= dto.getBoardWriter() %></td>
        	 <td><%= dto.getBoardCount() %></td></tr>
        <% }%>
        
</table>
<a href="/talkToMe_semi/main.1">메인화면으로 가기</a>
</body>
</html>