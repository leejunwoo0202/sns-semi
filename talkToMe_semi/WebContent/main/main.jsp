<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.websocket.Session"%>



<!DOCTYPE html>
<html>
<head>



<meta charset="UTF-8">
<title>메인화면</title>
<style>
#tb1 {
   width:300px;
   height:200px;
   position: absolute;
   top: 0px;
   right:10px;
  }
  
  #tb2 {
    width:300px;
    position:absolute;
    top: 0px;
    left:300px
       }
       
  #tb3{
     
  }    
</style>
  
<script type="text/javascript">
	function login() {
		if (document.frm.memberId.value == "") {
			alert("아이디를 입력해주세요");
			document.frm.memberId.focus();
			return false;
		}
		if (document.frm.memberPassword.value == "") {
			alert("비밀번호를 입력해주세요");
			document.frm.memberPassword.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<h2>메인화면입니다</h2>
	<%
		if (session.getAttribute("memberId") == null) {
	%>

	<form action="mainLogin.1" onsubmit="return login();" name="frm" method="get">
		<table border="1">
		
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="memberId" />
					<div>
						<%
							if (session.getAttribute("errId") != null) {
							out.print(session.getAttribute("errId"));
						}
						%>
					</div></td>
				<td rowspan="2"><input type="submit" value="로그인" /></td>
			</tr>
			<tr>
				<td>비밀번호 :</td>
				<td><input type="password" name="memberPassword" />
					<div>
						<%
							if (session.getAttribute("errPw") != null) {
							out.print(session.getAttribute("errpw"));
						}
						%>
					</div></td>
				<td rowspan="2"></td>
			</tr>
			<tr>
				<td colspan="2"><a href="member/membersignup.jsp">회원등록</a></td>
			</tr>

		</table>
	</form>
	<%
		}
	%>

<%
	if (session.getAttribute("memberId") != null) {
%>

	<!--  로그인이 된 상태 -->
	<table border="1" id="tb1">
		<tr><td><%=session.getAttribute("memberId")%></td></tr>
		
		
		<tr>
			<th><a href="member/memberList.5">리스트페이지</a></th>
		</tr>
		<tr>
			<th><a href="member/memberSearch.5">검색하기</a></th>
		</tr>
		<tr>
		    <th><a href="member/memberDelete.jsp">삭제하기</a>
		</tr>
		<tr><th><a href="logout.1">로그아웃</a></th></tr>
		<tr><th><a href="member/memberUpdate.5">회원정보 수정</a></th></tr>
		<tr><th>
		    <a href="admin/adminList.6">관리자 화면</a>
		</th></tr>

		</table>
	
	
	
		<table border="1"  id="tb2">
		<tr><th><a href="board/boardWrite.4">글쓰기 페이지로 이동</a>
		<th><a href="board/boardList.4">글목록 보기</a></th></tr>
	    </table>
	
	<table border="1"  id="tb3">
	  
	  <tr><th><a href="friends/friendsMain.2">친구메인</a></th></tr>
	  <tr><th><a href="group/groupMain.3">그룹</a></th></tr>
	</table>
<%
	}
%>
    <table border="1" id="tb4">
       <tr><th><a href="admin/adminMain.6">관리자 메인페이지</a></th></tr>
    </table>
</body>
</html>

