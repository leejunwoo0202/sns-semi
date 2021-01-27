package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;
import model.DTO.BoardDTO;

public class BoardInfoAction {
	public void execute(HttpServletRequest request) {
               String boardNum = request.getParameter("boardNum");
               BoardDAO dao = new BoardDAO();
               dao.updateCount(boardNum);
               BoardDTO dto = dao.boardOneSelect(boardNum);
               request.setAttribute("board",dto);
}
}