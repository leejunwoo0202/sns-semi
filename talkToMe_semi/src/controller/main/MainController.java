package controller.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainController extends HttpServlet{
           
	public void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/main.1")) {
			HttpSession session1 = request.getSession();
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"/main/main.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/mainLogin.1")){
			MainLoginAction action = new MainLoginAction();
			action.execute(request);
			response.sendRedirect("main.1");
			
		}else if(command.equals("/logout.1")) {
   		 HttpSession session = request.getSession();
   		 session.invalidate();
   		 response.sendRedirect("main.1");
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
