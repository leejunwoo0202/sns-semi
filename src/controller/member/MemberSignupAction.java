package controller.member;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberSignupAction {
	
         public void execute(HttpServletRequest request) {
        	 try {
        		 request.setCharacterEncoding("utf-8");
        	 }catch(UnsupportedEncodingException e1) {
        		 e1.printStackTrace();
        	 }
        	 MemberDTO dto = new MemberDTO();
        	 dto.setMemberId(request.getParameter("memberId"));
        	 dto.setMemberPassword(request.getParameter("memberPassword"));
        	 dto.setMemberTel(request.getParameter("memberTel"));
        	 dto.setMemberGender(request.getParameter("memberGender"));
        	 
        	MemberDAO dao = new MemberDAO();
        	
        	
            dao.insertMember(dto);
        	
         
            
        	
        	System.out.print("가입이 완료되었습니다.");
         }
}
