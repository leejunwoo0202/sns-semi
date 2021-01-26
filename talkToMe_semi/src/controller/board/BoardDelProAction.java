package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;
import model.DTO.BoardDTO;

public class BoardDelProAction {
      public void execute(HttpServletRequest request) {
    	  String boardNum = request.getParameter("boardNum");
    	  String boardPw = request.getParameter("boardPw");
    	  BoardDTO dto = new BoardDTO();
    	  dto.setBoardNum(Integer.parseInt(boardNum));
    	  dto.setBoardPw(boardPw);
    	  BoardDAO dao = new BoardDAO();
    	  dao.boardDelete(dto);
      }
}
