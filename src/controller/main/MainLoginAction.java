package controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MainLoginAction {
	public void execute(HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memberOneSelect(memberId);
		
		HttpSession session = request.getSession();
		if(dto != null) {
			if(dto.getMemberPassword().equals(memberPassword)) {
				System.out.println("사용자가 로그인 되었습니다.");
				
				session.setAttribute("memberId", dto.getMemberId());
			
				session.removeAttribute("errId");
				session.removeAttribute("errPw");
				
			
			}else {
				System.out.println("비밀번호가 틀립니다.");
				session.setAttribute("errPw", "비밀번호가 틀렸습니다.");
				
			}
		} else {
			System.out.println("사용자가 없습니다.");
			session.setAttribute("errId","사용자가 없습니다.");
			session.removeAttribute("errId");
		
		
		
		
		}
}
}