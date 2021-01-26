package controller.member;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberDeleteAction {
         public void execute(HttpServletRequest request)
        		 throws Exception   {
        	MemberDTO dto = new MemberDTO();
        	dto.setMemberId(request.getParameter("memberId"));
        	System.out.println(dto.getMemberId());
        	dto.setMemberPassword(request.getParameter("memberPassword"));
        	System.out.println(dto.getMemberPassword());
        	MemberDAO dao = new MemberDAO();
        	dao.memberDelete(dto);
        	 
        	 
        	 
        	 
         }
}
