package controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.AdminDAO;

public class adminListAction {
    
	public void execute(HttpServletRequest request) {
		AdminDAO dao = new AdminDAO();
		List list = dao.AdminAllSelect();
		Integer count = dao.adminCount();
		request.setAttribute("adminList", list);
		request.setAttribute("adminCount", count);
	}
}
