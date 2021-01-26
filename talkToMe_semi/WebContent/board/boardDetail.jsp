<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.DTO.*" %>
<%
   BoardDTO dto = (BoardDTO)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardModify.4" name="frm" method="post">
<input type="hidden" name="boardNum" value="<%= dto.getBoardNum() %>"/>
<table border="1">
   <tr><td>글쓴이 ip :<%= dto.getIpAddr() %></td>
       <td>방문자 수 : <%= dto.getBoardCount() %></td></tr>
   <tr><td>글쓴이 :</td><td><%= dto.getBoardWriter() %></td></tr>
   <tr><td>제목 :</td><td><%= dto.getBoardSubject() %></td></tr>
   <tr><td>내용 :</td><td><%= dto.getBoardContent().replace("\n","<br/>") %></td></tr>
   <tr><td>비밀번호</td>
       <td><input type="password" name="boardPw"/></td></tr>
       <tr><td colspan="2">
           <input type="submit" value="수정하러가기"/>
           <input type="button" value="리스트페이지로 이동" 
           onclick="javascript:history.back();"/>
           <input type="button" value="삭제" onclick="del();"/>
           
   
</table>

</form>

</body>
</html>
<script>
    function del(){
    	var boardNum = document.frm.boardNum.value;
    	var boardPw = document.frm.boardPw.value;
    	location.href="boardDelPro.4?boardNum="+boardNum+"&boardPw="+boardPw;
    }
</script>