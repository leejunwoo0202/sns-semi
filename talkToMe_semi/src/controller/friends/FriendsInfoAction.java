package controller.friends;

import javax.servlet.http.HttpServletRequest;

import model.DAO.FriendsDAO;
import model.DTO.FriendsDTO;

public class FriendsInfoAction {
        public void execute(HttpServletRequest request) {
        	String memberId = request.getParameter("memberId");
        	FriendsDAO dao = new FriendsDAO();
        	FriendsDTO dto = dao.FriendsOneSelect(memberId);
        	request.setAttribute("dto",dto);
        }
}
