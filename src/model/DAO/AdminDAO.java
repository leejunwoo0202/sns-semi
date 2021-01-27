package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.AdminDTO;

public class AdminDAO {
    
	    final String COLUMN = " admin_id, admin_password, admin_tel, admin_gender "; 
	    String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	    String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	    Connection conn;
	    PreparedStatement pstmt;
	    String sql;
	    ResultSet rs;
		
	    
	    public Connection getConnection() {
	    	Connection con = null;
	    	try {
	    		Class.forName(jdbcDriver);
	    		con = DriverManager.getConnection(jdbcURL, "smrit", " oracle");
	    		
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}return con;
	    	
	    }
	    
	    public void close() {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	    
	    public void insertAdmin(AdminDTO dto) {
	        
	    	conn = getConnection();
	    	sql = " insert into admin(" + COLUMN + ")" + " values(?,?,?,?)";
	    	try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getAdminId());
				pstmt.setString(2, dto.getAdminPassword());
				pstmt.setString(3, dto.getAdminTel());
				pstmt.setString(4, dto.getAdminGender());
				
				int i = pstmt.executeUpdate();
				System.out.println( i + "개가 저장되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
	    	
			
	    	
	    }
	    
	    
	    public List AdminAllSelect() {
			List<AdminDTO> list = new ArrayList();
	    	conn = getConnection();
	    	sql = " select " + COLUMN + " from admin ";
	        try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					AdminDTO dto = new AdminDTO();
					dto.setAdminId(rs.getString("admin_id"));
					dto.setAdminTel(rs.getString("admin_tel"));
					dto.setAdminGender(rs.getString("admin_gender"));
					list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
				close();
			}
	    	return list;
	    	
	    }
	    
	    public Integer AdminCount() {
	    	Integer i = null;
	    	conn = getConnection();
	    	sql = "select count(*) cnt from admin ";
	    	try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				rs.next();
				i = rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
				
			}return i;
	    	
	    }
	    
	    public AdminDTO AdminOneSelect(String adminId) {
	    	AdminDTO dto = null;
	    	conn = getConnection();
	    	sql = " select " + COLUMN + " from admin "
	    		+ " where Admin_id = ? ";
	    	try {
	    		pstmt = conn.prepareStatement(sql);
	    		pstmt.setString(1, adminId);
	    		rs = pstmt.executeQuery();
	    		if(rs.next()) {
	    			dto = new AdminDTO();
	    			dto.setAdminId(rs.getString("admin_id"));
	    			dto.setAdminPassword(rs.getString("admin_password"));
	    			dto.setAdminTel(rs.getString("admin_tel"));
	    			dto.setAdminGender(rs.getString("admin_gender"));
	    			
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return dto;
	    }
	    
	    public void adminUpdate(AdminDTO dto) {
	    	conn = getConnection();
	    	sql = " update admin set admin_password=?, "
	    		+ " admin_tel=? where admin_id= ?";
	    	try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getAdminPassword());
				pstmt.setString(2, dto.getAdminTel());
				pstmt.setString(3, dto.getAdminId());
				int i = pstmt.executeUpdate();
				System.out.println(i + " 개가 수정되었습니다.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    public void adminDelete(AdminDTO dto) {
	    	conn = getConnection();
	    	sql = " delete from admin "
	    		+ " where admin_id=? and admin_password=? ";
	    	try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getAdminId());
				pstmt.setString(2, dto.getAdminPassword());
				int i = pstmt.executeUpdate();
				System.out.println( i + " 개가 삭제되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
	    	
	    }
	    
	
}
