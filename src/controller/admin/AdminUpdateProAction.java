package controller.admin;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.AdminDAO;
import model.DTO.AdminDTO;

public class AdminUpdateProAction {
      public void execute(HttpServletRequest request) {
    	  try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  AdminDTO dto = new AdminDTO();
    	  
    	  dto.setAdminId(request.getParameter("adminId"));
    	  dto.setAdminPassword(request.getParameter("adminPassword"));
    	  dto.setAdminTel(request.getParameter("adminTel"));
    	  
    	  AdminDAO dao = new AdminDAO();
    	  dao.adminUpdate(dto);
    	  
      }
}
