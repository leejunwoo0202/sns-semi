package controller.friends;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FriendsController extends HttpServlet{
         public void doProcess(HttpServletRequest request,
        		 HttpServletResponse response)
         throws ServletException, IOException{
        	 
        	 String requestURI = request.getRequestURI();
        	 String contextPath = request.getContextPath();
        	 String command = requestURI.substring(contextPath.length());
        	 if(command.equals("/friends/friendsSelect.2")) {
        		    RequestDispatcher dispatcher =
        		    		request.getRequestDispatcher(
        		    				"/friends/friendsSelect.jsp");
        		    dispatcher.forward(request, response);
        		 
        		 
        	 }else if(command.equals("/friends/friendsSelectPro.2")) {
        		 FriendsListAction action = new FriendsListAction();
        		 action.execute(request);
        		 RequestDispatcher dispatcher = 
        				 request.getRequestDispatcher(
        						 "/friends/friendsSelectPro.jsp");
        		 dispatcher.forward(request, response);
        		 
        	 }else if(command.equals("/friends/friendsInsert.2")) {
        		 RequestDispatcher dispatcher = 
        				 request.getRequestDispatcher(
        						 "/friends/friendsInsert.jsp");
        		 dispatcher.forward(request,response);
        	 }else if(command.equals("/friends/friendsInsertPro.2")) {
        		 FriendsInsertProAction action = new FriendsInsertProAction();
        		 action.execute(request);
        		 RequestDispatcher dispatcher =
        				 request.getRequestDispatcher(
        						 "/friends/friendsInsertPro.jsp");
        		 dispatcher.forward(request,response);
        		 
        		 
        	 }else if(command.equals("/friends/friendsMain.2")) {
        		 RequestDispatcher dispatcher =
        				 request.getRequestDispatcher(
        						 "/friends/friendsmain.jsp");
        		 dispatcher.forward(request, response);
        	 }else if(command.equals("/friends/friendsInfo.2")) {
        		 FriendsInfoAction action = new FriendsInfoAction();
        		 action.execute(request);
        		 RequestDispatcher dispatcher =
        				 request.getRequestDispatcher(
        						 "/friends/friendsInfo.jsp");
        		 dispatcher.forward(request, response);
        		 
        	 }
        	 
         }
         
         @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	 doProcess(req,resp);
        }
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             doProcess(req,resp);
        } 
}
