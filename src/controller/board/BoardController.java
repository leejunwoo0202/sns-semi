package controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;    

public class BoardController extends HttpServlet{
        
	public void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/board/boardList.4")) {
			BoardListAction action = new BoardListAction();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(
							"/board/boardList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/board/boardWrite.4")) {
			RequestDispatcher dispatcher =
				 request.getRequestDispatcher("/board/boardWrite.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/board/boardWritePro.4")){
			BoardWriteAction action =
					new BoardWriteAction();
			try {
				action.execute(request);
				response.sendRedirect("boardList.4");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}else if(command.equals("/board/boardDetail.4")) {
			BoardInfoAction action = new BoardInfoAction();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"/board/boardDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/board/boardModify.4")) {
			BoardModifyAction action = new BoardModifyAction();
			boolean path = action.execute(request);
			if(path) {
				RequestDispatcher dispatcher =
						request.getRequestDispatcher(
								"/board/boardModify.jsp");
				dispatcher.forward(request,response);
			}else {
				response.sendRedirect(
						"boardInfo.4?boardNum="
						+request.getParameter("boardNum"));
	        }
		}else if(command.equals("/board/boardModifyPro.4")) {
			BoardModifyProAction action =
					new BoardModifyProAction();
			action.execute(request);
			response.sendRedirect("boardList.4");
		}else if(command.equals("/board/boardDelPro.4")) {
			BoardDelProAction action = new BoardDelProAction();
			action.execute(request);
			response.sendRedirect("boardList.4");
		}
				
			
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}	
	
}
