package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberUpdateAction {
      public boolean execute(HttpServletRequest request)throws Exception {
    	 
    	 //입력한 비밀번호와 해당 회원이 비밀번호를 비교하는 메소드
    	  String memberId = request.getParameter("memberId");
    	  String memberPassword = request.getParameter("memberPassword");
    	  MemberDAO dao = new MemberDAO();
    	  MemberDTO dto = dao.memberOneSelect(memberId);
    	  boolean path = false;
    	  if(memberPassword.equals(dto.getMemberPassword() )) {
    		  request.setAttribute("member", dto);
    		 path = true;
    	  }
    	  
    	  
    	  return path;
    	  
      }
}
