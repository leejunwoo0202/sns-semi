package controller.member;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberSearchAction {
       public void execute(HttpServletRequest request ) {
    	   MemberDAO dao = new MemberDAO();
    	   MemberDTO dto = new MemberDTO();
    	   dto.setMemberId(request.getParameter("memberId"));
    	   
    	   dao.memberSearch(dto);
    	   
    	   
    	   List list = dao.memberOneSearch();
           
           request.setAttribute("memberList", list);
           
    	 
       }
}
