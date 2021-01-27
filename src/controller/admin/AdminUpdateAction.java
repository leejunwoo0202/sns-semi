package controller.admin;

import javax.servlet.http.HttpServletRequest;

import model.DAO.AdminDAO;
import model.DTO.AdminDTO;

public class AdminUpdateAction {
      public boolean execute(HttpServletRequest request)throws Exception{
    	  
    	  String adminId = request.getParameter("adminId");
    	  String adminPassword = request.getParameter("adminPassword");
    	  AdminDAO dao = new AdminDAO();
    	  AdminDTO dto = dao.AdminOneSelect(adminId);
    	  boolean path = false;
    	  if(adminPassword.equals(dto.getAdminPassword())) {
    		  request.setAttribute("admin", dto);
    		  path = true;
    	  }
     return path;
      
      
      }
}
