package controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.AdminDAO;

public class adminListAction {   
	public void execute(HttpServletRequest request) {
		AdminDAO dao = new AdminDAO();
		List adminList = dao.AdminAllSelect();
		Integer adminCount = dao.AdminCount();
		request.setAttribute("adminList", adminList);
		request.setAttribute("adminCount", adminCount);
	}
}
