package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.FriendsDTO;
import model.DTO.MemberDTO;

public class FriendsDAO {
          
	       final String COLUMN = " member_id, friends_id ";
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
           		con = DriverManager.getConnection(jdbcURL,"smrit","oracle");
           	}catch(Exception e) {
           		e.printStackTrace();
           	}
           	return con;
           }
	       
	       public void close() {
       		if(rs != null)
       			try {rs.close();} catch (SQLException e) {}
       		if(pstmt != null)
       			try {pstmt.close();} catch (SQLException e) {}
       		if(conn != null)
       			try {conn.close();} catch (SQLException e) {}
       	}
	       
	  public void insertFriends(FriendsDTO dto) {
		  conn = getConnection();
		  sql = " insert into friends(" + COLUMN + ")" + " values(?,?)";
		  try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getFriendsId());
			int i = pstmt.executeUpdate();
			System.out.println( i + "개가 저장되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	  }
	  
		
		
		
		public Integer friendsCount() {
			Integer i = null;
			conn = getConnection();
			sql = "select count(*) cnt from friends";
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
		
		public void FriendsSearch(FriendsDTO dto) {
			conn = getConnection();
			sql = " select friends_id "
			    + " from friends where member_id = ? ";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getMemberId());
				int i = pstmt.executeUpdate();
				System.out.println( i + "개가 검색 되었습니다.");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
		}
		
		public FriendsDTO FriendsOneSelect(String memberId) {
			FriendsDTO dto = null;
			conn = getConnection();
			sql = " select " + COLUMN + " from friends where member_id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberId);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					dto = new FriendsDTO();
					dto.setMemberId(rs.getString("member_id"));
					dto.setFriendsId(rs.getString("friends_id"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return dto;
			
		}
		public List FriendsOneSelectVer1(String memberId) {
			List list = new ArrayList();
	        
		conn = getConnection();
		sql = " select friends_id from friends where member_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FriendsDTO dto = new FriendsDTO();
				dto.setMemberId(memberId);
				dto.setFriendsId(rs.getString("friends_id"));
				list.add(dto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
		
	}
}
