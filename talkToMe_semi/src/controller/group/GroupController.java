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
	    		 RequestDispatcher dispatcher = request.getRequestDispatcher(
	    				 "/group/grouplist.jsp");
	    		 dispatcher.forward(request,response);
	    	 }else if(command.equals("/group/groupMain.3")) {
	    		 RequestDispatcher dispatcher = request.getRequestDispatcher(
	    				 "/group/groupMain.jsp");
	    		 dispatcher.forward(request,response);
	    	 }
	    	 
	     }
	     
	     @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
	    }
	     
	     @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	    }
}
