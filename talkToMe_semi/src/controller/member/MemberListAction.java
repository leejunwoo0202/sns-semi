package controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;

public class MemberListAction {
	
	public void execute(HttpServletRequest request) {
       MemberDAO dao = new MemberDAO();
       List list = dao.memberAllSelect();
       Integer count = dao.memberCount();
       request.setAttribute("memberList", list);
       request.setAttribute("memberCount", count);
}
}