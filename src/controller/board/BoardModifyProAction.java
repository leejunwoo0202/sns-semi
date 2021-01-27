package controller.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;
import model.DTO.BoardDTO;

public class BoardModifyProAction {
              public void execute(HttpServletRequest request) {
            	  try {
					request.setCharacterEncoding("UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
            	  BoardDTO dto = new BoardDTO();
            	  dto.setBoardNum(Integer.parseInt(
            			  request.getParameter("boardNum")));
            	  dto.setBoardSubject(request.getParameter("boardSubject"));
            	  dto.setBoardContent(request.getParameter("boardContent"));
            	  dto.setBoardPw(request.getParameter("boardPw"));
            	  BoardDAO dao = new BoardDAO();
            	  dao.boardUpdate(dto);
              }
}
