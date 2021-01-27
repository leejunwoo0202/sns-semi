package controller.group;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GroupController extends HttpServlet {
          
	     public void doProcess(HttpServletRequest request, HttpServletResponse response)
	                  throws Exception{
	    	 String requestURI = request.getRequestURI();
	    	 String ContextPath = request.getContextPath();
	    	 String command = requestURI.substring(ContextPath.length());
	    	 
	    	 if(command.equals("/group/groupList.3")) {
	    		 GroupListAction action = new GroupListAction();
	    		 action.execute(request);
	    		 RequestDispatcher dispatcher = request.getRequestDispatcher(
	    				 "/group/groupList.jsp");
	    		 dispatcher.forward(request, response);
	    		 
	    		 
	    	 }else if(command.equals("/group/groupMain.3")) {
	    		 RequestDispatcher dispatcher = request.getRequestDispatcher(
	    				 "/group/groupMain.jsp");
	    		 dispatcher.forward(request,response);
	    	 }else if(command.equals("/group/groupInsert.3")) {
	    		 RequestDispatcher dispatcher = request.getRequestDispatcher(
	    				 "/group/groupInsert.jsp");
	    		 dispatcher.forward(request, response);
    	 }
    		 else if(command.equals("/group/groupInsertPro.3")) {
	    		 GroupInsertProAction action = new GroupInsertProAction();
	    		 action.execute(request);
	    		 response.sendRedirect("groupList.3");
	    				 
	    	 }
	    	 
	    		 
	    		 
	    	 }
	    	 
	     
	     
	     @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        try {
				doProcess(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	     
	     @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	 try {
				doProcess(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
