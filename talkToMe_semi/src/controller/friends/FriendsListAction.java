package controller.friends;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.FriendsDAO;

public class FriendsListAction {
           
	   public void execute(HttpServletRequest request) {
		   
		   String memberId = request.getParameter("memberId");
		   FriendsDAO dao = new FriendsDAO();
		   List list =dao.FriendsOneSelectVer1(memberId);
		   Integer count = dao.friendsCount();
		   request.setAttribute("list",list);
		   request.setAttribute("count", count);
		   
		   
	   }
}
