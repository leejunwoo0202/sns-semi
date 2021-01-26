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
    
	    final String COLUMN = " ADMIN_ID, ADMIN_PASSWORD, ADMIN_TEL, ADMIN_GENDER ";
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
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
	    	return list;
	    	
	    }
	    
	    public Integer adminCount() {
	    	Integer i = null;
	    	conn = getConnection();
	    	sql = "select count(*) cnt from member ";
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
	    
	    
	    
	    
	
}
