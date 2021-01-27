package controller.friends;

import javax.servlet.http.HttpServletRequest;

import model.DAO.FriendsDAO;
import model.DTO.FriendsDTO;

public class FriendsInsertProAction {
           public void execute(HttpServletRequest request) {
        	    FriendsDTO dto = new FriendsDTO();
        	    dto.setMemberId(request.getParameter("memberId"));
        	    dto.setFriendsId(request.getParameter("friendsId"));

        	    FriendsDAO dao = new FriendsDAO();
        	    dao.insertFriends(dto);
        	    System.out.println("가입완료");
           }
}
