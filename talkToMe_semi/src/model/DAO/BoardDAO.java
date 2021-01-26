package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.BoardDTO;

public class BoardDAO {
            final String COLUMN = " board_num, member_id, board_writer, "
            		            + " board_subject, board_content, board_pw, "
            		            + " board_count, ip_addr";
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
            
            public void insertBoard(BoardDTO dto) {
            	conn = getConnection();
            	String subquery = "select nvl(max(board_num), 0) + 1 from board";
            	sql = " insert into board("+ COLUMN + ")"
            		+ " VALUES( (" + subquery + "),?,?,?,?,?,0,?)";
            	try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dto.getMemberId());
					pstmt.setString(2, dto.getBoardWriter());
					pstmt.setString(3, dto.getBoardSubject());
					pstmt.setString(4, dto.getBoardContent());
					pstmt.setString(5, dto.getBoardPw());
					pstmt.setString(6, dto.getIpAddr());
					int i = pstmt.executeUpdate();
					System.out.println(i + "개가 저장되었습니다.");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					close();
				}
 
            	
            }
            
            public List boardAllSelect() {
            	List list = new ArrayList();
            	conn = getConnection();
            	sql = "select" + COLUMN + " from board";
				try {
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						BoardDTO dto = new BoardDTO();
						dto.setBoardContent(rs.getString("board_content"));
						dto.setBoardCount(rs.getInt("board_count"));
						dto.setBoardNum(rs.getInt("board_num"));
						dto.setBoardPw(rs.getString("board_pw"));
						dto.setBoardSubject(rs.getString("board_subject"));
						dto.setBoardWriter(rs.getString("board_writer"));
						dto.setIpAddr(rs.getString("ip_addr"));
						dto.setMemberId(rs.getString("member_id"));
						list.add(dto);
					}
					}catch(SQLException e) {
						e.printStackTrace();
					}finally {
						close();
					}
					return list;
				}
            	
            public Integer boardCount() {
            	Integer count = null;
            	conn = getConnection();
            	sql = " select count(*) from board ";
            	try {
            		pstmt = conn.prepareStatement(sql);
            		rs = pstmt.executeQuery();
            		rs.next();
            		count = rs.getInt(1);
            	}catch(SQLException e) {
            		e.printStackTrace();
            	}finally {
            		close();
            	}
            	return count;
            }
            
            
          public void updateCount(String boardNum) {
        	  //방문자 수 1증가
        	  conn = getConnection();
        	  sql = " update board set board_count = board_count + 1 "
        	      + " where board_num = ?";
        	  try {
        		  pstmt = conn.prepareStatement(sql);
        		  pstmt.setString(1, boardNum);
        		  int i = pstmt.executeUpdate();
        		  System.out.println( i + "개가 수정되었습니다.");
        	  }catch(SQLException e) {
        		  e.printStackTrace();
        	  }finally {
        		  close();
        	  }
          }
            
          public BoardDTO boardOneSelect(String boardNum){
        	   BoardDTO dto = new BoardDTO();
        	   conn = getConnection();
        	   sql = " select " + COLUMN + " from board "
        		   + " where board_num = ? ";
        	   try {
        		   pstmt = conn.prepareStatement(sql);
        		   pstmt.setString(1, boardNum);
        		   rs = pstmt.executeQuery();
        		   if(rs.next()) {
        			   dto.setBoardContent(rs.getString("board_content"));
        			   dto.setBoardCount(rs.getInt("board_count"));
        			   dto.setBoardNum(rs.getInt("board_num"));
        			   dto.setBoardPw(rs.getString("board_pw"));
        			   dto.setBoardSubject(rs.getString("board_subject"));
        			   dto.setBoardWriter(rs.getString("board_writer"));
        			   dto.setIpAddr(rs.getString("ip_addr"));
        			   dto.setMemberId(rs.getString("member_id"));
        			   }
        		   }catch(SQLException e) {
        			   e.printStackTrace();
        	   }finally {
        		   close();
        	   }
			return dto;
          }
          
          public void boardUpdate(BoardDTO dto) {
        	  conn = getConnection();
        	  sql = " update board "
        	      + " set board_subject = ?, board_content = ? "
        		  + " where board_num = ? and board_pw ";
        	  try {
        		  pstmt = conn.prepareStatement(sql);
        		  pstmt.setString(1, dto.getBoardSubject());
        		  pstmt.setString(2, dto.getBoardContent());
        		  pstmt.setInt(3, dto.getBoardNum());
        		  pstmt.setString(4, dto.getBoardPw());
        		  int i = pstmt.executeUpdate();
        		  System.out.println( i + "개가 수정되었습니다.");
        	  }catch(SQLException e) {
        		  e.printStackTrace();
        	  }finally {
        		  close();
        	  }
          }
          
          public void boardDelete(BoardDTO dto) {
        	  conn = getConnection();
        	  sql = " delete from board "
        		  + " where board_num = ? and board_pw = ? ";
        	  try {
				pstmt =  conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getBoardNum());
				pstmt.setString(2, dto.getBoardPw());
				int i = pstmt.executeUpdate();
				System.out.println(i + "개가 삭제되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
          }
          
          
          
            }
            
            
            
            

