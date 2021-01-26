package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;
import model.DTO.BoardDTO;

public class BoardWriteAction {
       public void execute(HttpServletRequest request)
    		   throws Exception {
    	  
    	try {   
           request.setCharacterEncoding("UTF-8");    
    	}catch(Exception e){
            e.printStackTrace();
    	}
    	
    	BoardDTO dto = new BoardDTO();
    	dto.setBoardWriter(request.getParameter("boardWriter"));
    	dto.setBoardSubject(request.getParameter("boardSubject"));
    	dto.setBoardContent(request.getParameter("boardContent"));
    	dto.setBoardPw(request.getParameter("boardPw"));
    	
    	BoardDAO dao = new BoardDAO();
    	dao.insertBoard(dto);
    	
       }
    	
    	}
    	
