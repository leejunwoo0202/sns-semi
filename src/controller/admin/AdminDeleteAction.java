package controller.admin;

import javax.servlet.http.HttpServletRequest;

import model.DAO.AdminDAO;
import model.DTO.AdminDTO;

public class AdminDeleteAction {
         public void execute(HttpServletRequest request) {
        	 AdminDTO dto = new AdminDTO();
        	 dto.setAdminId(request.getParameter("adminId"));
        	 System.out.println(dto.getAdminId());
        	 dto.setAdminPassword(request.getParameter("adminPassword"));
        	 System.out.println(dto.getAdminPassword());
        	 AdminDAO dao = new AdminDAO();
        	 dao.adminDelete(dto);
         }
}
