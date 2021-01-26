package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;
import model.DTO.BoardDTO;

public class BoardModifyAction {
	public boolean execute(HttpServletRequest request) {
		String boardNum = request.getParameter("boardNum");
		String boardPw = request.getParameter("boardPw");
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.boardOneSelect(boardNum);
		boolean path = false;
		if(boardPw.equals(dto.getBoardPw())) {
			request.setAttribute("board", dto);
			path = true;
		}
		return path;
	}
}
