<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.DTO.*"%>
<%   
    MemberDTO dto = (MemberDTO)request.getAttribute("member");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<h2>검색결과 페이지</h2>
<table border="1" align="center">


	<tr>
		<td>아이디</td>
		<td>전화번호</td>
		<td>성별</td>
	</tr>
	
	<tr>
		<td><%=dto.getMemberId()%></td>
		<td><%=dto.getMemberTel()%></td>
		<td><%=dto.getMemberGender()%></td>
	</tr>

</table>
</body>
</html>