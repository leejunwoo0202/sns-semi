package controller.group;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GroupDAO;

public class GroupListAction {
	public void execute(HttpServletRequest request) {
         GroupDAO dao = new GroupDAO();
         List list = dao.groupAllselect();
         Integer count = dao.groupCount();
         request.setAttribute("groupList",list);
         request.setAttribute("groupCount",count);

	}
}
