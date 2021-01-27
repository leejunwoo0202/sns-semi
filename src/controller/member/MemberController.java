package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DTO.MemberDTO;

public class MemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doProcess(HttpServletRequest request,
		HttpServletResponse response) 
				throws Exception{
	String requestURI = request.getRequestURI();
	String contextPath = request.getContextPath();
	String command = requestURI.substring(contextPath.length());
	
	        //회원가입 페이지로 이동하는 로직      	
	if(command.equals("/member/membersignup.5")) {  
		RequestDispatcher dispatcher =
				 request.getRequestDispatcher(
						 "/member/membersignup.jsp");
		 dispatcher.forward(request, response);
	       //회원가입 정보 전달 후 저장 
	}if(command.equals("/member/membersignupComplete.5")) {
		MemberSignupAction action =  new MemberSignupAction();
		action.execute(request);
		
		RequestDispatcher dispatcher =
			 request.getRequestDispatcher(
					 "/member/membersignupComplete.jsp");
	 dispatcher.forward(request, response);
	
	     //회원정보 수정페이지로 이동
	}else if(command.equals("/member/memberUpdate.5")) {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/member/memberUpdate.jsp");
		dispatcher.forward(request, response);
		//회원정보 수정페이지에서 입력한 비밀번호 확인하는 로직(유효성 검사)
	}else if(command.equals("/member/memberUpdateAction.5")) {
		MemberUpdateAction action = new MemberUpdateAction();
		boolean path = action.execute(request);
		if(path) {
			   RequestDispatcher dispatcher =
					   request.getRequestDispatcher(
							   "/member/memberUpdateProAction.jsp");
			   dispatcher.forward(request, response);
		}else {
			response.sendRedirect("memberUpdate.5?memberId="
					+ request.getParameter("memberId"));
		}
		//실제 업데이트 로직(데이터 db로 보내는 작업)
	}else if(command.equals("/member/memberUpdateProAction.5")) {
		MemberUpdateProAction action = new MemberUpdateProAction();
		action.execute(request);
		response.sendRedirect("memberList.5");
		
		
		//회원 리스트
	}else if(command.equals("/member/memberList.5")) {
		MemberListAction action = new MemberListAction();
		action.execute(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/member/memberList.jsp");
		dispatcher.forward(request,response);
	   //회원 한명검색(아이디를 검색하는 페이지로 이동)
	}else if(command.equals("/member/memberSearch.5")) {
	
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(
						"/member/memberSearch.jsp");
		dispatcher.forward(request, response);
		//실제로 아이디를 db와 비교해서 존재하면 화면에 정보를 출력
	}else if(command.equals("/member/memberSearchPro.5")) {
		MemberSearchAction action = new MemberSearchAction();
	   	action.execute(request);	
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/member/memberSearchPro.jsp");
		dispatcher.forward(request, response);
				
	
		//회원 삭제 페이지로 이동
	}else if(command.equals("/member/memberDelete.5")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(
						"/member/memberDelete.jsp");
		dispatcher.forward(request,response);
		//회원삭제 
	}else if(command.equals("/member/memberDeletePro.5")) {
		MemberDeleteAction action =
				new MemberDeleteAction();
		action.execute(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/member/memberDeleteComplete.jsp");
		dispatcher.forward(request, response);
	}

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doProcess(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doProcess(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
