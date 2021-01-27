package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.MemberDTO;

public class MemberDAO {
	final String COLUMN = " MEMBER_ID, MEMBER_PASSWORD, MEMBER_TEL, MEMBER_GENDER ";
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

	public void insertMember(MemberDTO dto) {
		
		conn = getConnection();
		sql = "insert into member(" + COLUMN + ")" 
		    + " values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPassword());
			pstmt.setString(3, dto.getMemberTel());
			pstmt.setString(4, dto.getMemberGender());
			
			
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 저장되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	

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

	public void memberUpdate(MemberDTO dto) {
		conn = getConnection();
		sql = " update member set member_password=?,"
		    + " member_tel=? where member_id= ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberPassword());
			pstmt.setString(2, dto.getMemberTel());
			pstmt.setString(3, dto.getMemberId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List memberAllSelect() {
		List<MemberDTO> list = new ArrayList();
		conn = getConnection();
		sql = " select " + COLUMN + " from member ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 레코드의 갯수만큼 dto 생성
				MemberDTO dto = new MemberDTO();
				dto.setMemberId(rs.getString("member_id"));
				dto.setMemberTel(rs.getString("member_tel"));
				dto.setMemberGender(rs.getString("member_gender"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}


	public Integer memberCount() {
		Integer i = null;
		conn = getConnection();
		sql = "select count(*) cnt from member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			i = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return i;
	}
	
	
	

	public MemberDTO memberLogin(String memberId,String memberPassword) {
		    MemberDTO dto = null;
		    conn = getConnection();
		    sql = " select member_id, member_password from member "
		    	+ " where member_id = ? and member_password = ?";
		    try {
		    	pstmt = conn.prepareStatement(sql);
		    	pstmt.setString(1, memberId);
		    	pstmt.setString(2, memberPassword);
		    	rs = pstmt.executeQuery();
		    	if(rs.next()){
		    		dto = new MemberDTO();
		    		dto.setMemberId(rs.getString("member_id"));
		    		dto.setMemberPassword(rs.getString("member_password"));
		    	}	
		    	}catch(SQLException e) {
		    		e.printStackTrace();
		    	}
			return dto;
		    	
		    	
		    }
        
	public void memberSearch(MemberDTO dto) {
		
		conn = getConnection();
		sql = " select member_id, member_tel, member_gender "
			+ " from member where member_id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 검색 되었습니다.");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
	}
	
	public void memberDelete(MemberDTO dto) {
		 conn = getConnection();
		 sql = " delete from member "
		     + " where member_id=? and member_password=?";
		 try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPassword());
			int i = pstmt.executeUpdate();
			System.out.println( i + "개가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		}
		
		 
		 
	
		
	public MemberDTO memberOneSelect(String memberId) {
		MemberDTO dto = null;
		conn = getConnection();
		sql = " select " + COLUMN + " from member "
			+ " where member_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(); //조회결과가 있을 때만 객체 생성
				dto.setMemberId(rs.getString("MEMBER_ID"));
				dto.setMemberPassword(rs.getString("member_Password"));
				dto.setMemberTel(rs.getString("member_Tel"));
				dto.setMemberGender(rs.getString("member_Gender"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}	
	public List memberOneSearch() {
		List list = new ArrayList();
		conn = getConnection();
		sql = " select  member_id, member_tel, member_gender "
			+ " from member where member_id = ? " ;
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				MemberDTO dto = new MemberDTO();
				dto.setMemberId(rs.getString("member_id"));
				dto.setMemberPassword(rs.getString("member_password"));
				dto.setMemberTel(rs.getString("member_tel"));
				dto.setMemberGender(rs.getString("member_gender"));
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
