package controller.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberUpdateProAction {
      public void execute(HttpServletRequest request) {
    	  try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	MemberDTO dto = new MemberDTO();
    	
    	dto.setMemberId(request.getParameter("memberId"));
    	dto.setMemberPassword(request.getParameter("memberPassword"));
    	dto.setMemberTel(request.getParameter("memberTel"));
    	
    	
    	MemberDAO dao = new MemberDAO();
    	dao.memberUpdate(dto);
    	  
      }
}
