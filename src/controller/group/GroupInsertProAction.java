package controller.group;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.GroupDAO;
import model.DTO.GroupDTO;

public class GroupInsertProAction {
         public void execute(HttpServletRequest request) 
              throws Exception{
        	 
        	 GroupDTO dto = new GroupDTO();
        	 String realPath =
        			 request.getSession().getServletContext().getRealPath(
        					 "/group/upload");
        	 int limitSize = 50 * 1024 * 1024;
        	 MultipartRequest multi =
        			 new MultipartRequest(request,realPath,limitSize,
        					 "UTF-8",new DefaultFileRenamePolicy());
        	 dto.setGroupName(multi.getParameter("groupName"));
        	 dto.setGroupAdmin(multi.getParameter("groupAdmin"));
        	 dto.setGroupKategorie(multi.getParameter("groupKategorie"));
        	 dto.setFileName(multi.getFilesystemName("fileName"));
        	 
        	 
        	 
        	 GroupDAO dao = new GroupDAO();
        	 dao.insertGroup(dto);
        	 
        
         }
}
