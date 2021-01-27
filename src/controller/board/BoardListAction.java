package controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;

public class BoardListAction {
     public void execute(HttpServletRequest request) {
    	 BoardDAO dao = new BoardDAO();
    	 List list = dao.boardAllSelect();
    	 Integer count = dao.boardCount();
    	 request.setAttribute("boardList", list);
    	 request.setAttribute("boardCount", count);
    	 
     }
}
