package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.GroupDTO;

public class GroupDAO {
	final String COLUMN = " group_name, group_admin , group_kategorie, file_name ";
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
			con = DriverManager.getConnection(jdbcURL, "smrit", "oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
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
	
	
	
	  public void insertGroup(GroupDTO dto) {
		  conn = getConnection();
		  sql = " insert into group1(" + COLUMN + ")"
			  + " values(?,?,?,?)";
		  try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGroupName());
			pstmt.setString(2, dto.getGroupAdmin());
			pstmt.setString(3, dto.getGroupKategorie());
			pstmt.setString(4, dto.getFileName());
			
			int i = pstmt.executeUpdate();
			System.out.println( i + "개가 저장되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		  
	  }
	  
	 public List groupAllselect() {
		 List<GroupDTO> list = new ArrayList();
		 conn = getConnection();
		 sql =  " select " +  COLUMN   +  " from group1 " ;
		 try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GroupDTO dto = new GroupDTO();
				dto.setGroupName(rs.getString("group_name"));
				dto.setGroupAdmin(rs.getString("group_admin"));
				dto.setGroupKategorie(rs.getString("group_kategorie"));
				dto.setFileName(rs.getString("file_name"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		 return list;
		 		
	 }
	  
	 
	 public Integer groupCount() {
			Integer i = null;
			conn = getConnection();
			sql = " select count(*) cnt from group1 ";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				rs.next();
				i = rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return i;
			
		}
	  
}
