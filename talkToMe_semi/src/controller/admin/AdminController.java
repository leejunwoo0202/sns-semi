package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.main.MainLoginAction;

public class AdminController extends HttpServlet {
          
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
	      throws Exception {
		
		  String requestURI = request.getRequestURI();
		  String contextPath = request.getContextPath();
		  String command = requestURI.substring(contextPath.length());
		  
		  if(command.equals("/admin/adminList.6")) {
			  RequestDispatcher dispatcher =
					  request.getRequestDispatcher(
							  "/admin/adminList.jsp");
			  dispatcher.forward(request, response);
		  
		}else if(command.equals("/admin/adminsignup.6")) {
			 RequestDispatcher dispatcher =
					 request.getRequestDispatcher(
							 "/admin/adminsignup.jsp");
			 dispatcher.forward(request, response);
			
		}else if(command.equals("/admin/adminsignupComplete.6")) {
			AdminSignupAction action = new AdminSignupAction();
			action.execute(request);
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"/admin/adminsignupComplete.jsp");
			dispatcher.forward(request, response);
			
			
		}else if(command.equals("/admin/adminMain.6")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"/admin/adminMain.jsp");
			dispatcher.forward(request, response);
					
		}else if(command.equals("admin/adminList.6")) {
			adminListAction action = new adminListAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/admin/adminList.jsp");
			dispatcher.forward(request,response);
		}
		  
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doProcess(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doProcess(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
