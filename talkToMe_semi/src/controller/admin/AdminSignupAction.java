package controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.AdminDAO;
import model.DTO.AdminDTO;

public class AdminSignupAction {
         
	public void execute(HttpServletRequest request)
	               throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		AdminDTO dto = new AdminDTO();
		dto.setAdminId(request.getParameter("adminId"));
		dto.setAdminPassword(request.getParameter("adminPassword"));
		dto.setAdminTel(request.getParameter("adminTel"));
		dto.setAdminGender(request.getParameter("adminGender"));
		AdminDAO dao = new AdminDAO();
		dao.insertAdmin(dto);
		
		
		
		System.out.print("가입이 완료되었습니다.");
		
	}
}
