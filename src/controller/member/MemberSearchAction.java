package controller.member;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberSearchAction {
       public void execute(HttpServletRequest request ) {
    	   String memberId = request.getParameter("memberId");
    	   MemberDAO dao = new MemberDAO();
    	   MemberDTO dto = dao.memberOneSelect(memberId);
    	   request.setAttribute("member", dto);
    	   
    	   
    	   
    	   
    	   
           
           
           
    	 
       }
}
