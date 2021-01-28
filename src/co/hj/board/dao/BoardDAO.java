package co.hj.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.hj.board.common.DAO;
import co.hj.board.vo.BoardVO;

public class BoardDAO extends DAO{
	private PreparedStatement psmt;
	private ResultSet rs;

//전체조회
	public ArrayList<BoardVO> selectList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		String sql="SELECT * FROM board";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); 				//resultset을 통해서 받겠다
			while(rs.next()) { 						//resultset이 얼마나 많은 자료가 잇는지 모름
				vo = new BoardVO(); 				//vo 초기화
				vo.setbId(rs.getInt("bid"));
				vo.setbName(rs.getString("bname"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				vo.setbGroup(rs.getInt("bgroup"));
				vo.setbStep(rs.getInt("bstep"));
				vo.setbIndent(rs.getInt("bindent"));
				list.add(vo);			//담은것들을 리스트에 추가
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return list;
	}
	
//하나 조회	
	public BoardVO select(BoardVO vo) {
		String sql="SELECT * FROM board WHERE bid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
			vo.setbId(rs.getInt("bid"));
			vo.setbName(rs.getString("bname"));
			vo.setbTitle(rs.getString("btitle"));
			vo.setbContent(rs.getString("bcontent"));
			vo.setbDate(rs.getDate("bdate"));
			vo.setbHit(rs.getInt("bhit"));
			vo.setbGroup(rs.getInt("bgroup"));
			vo.setbStep(rs.getInt("bstep"));
			vo.setbIndent(rs.getInt("bindent"));	
			hitCount(vo.getbId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

//등록
	public int insert(BoardVO vo) {
		String sql="INSERT INTO board VALUES(?,?,?,?,?,0,0,0,0)";
		int n=0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			psmt.setString(2, vo.getbName());
			psmt.setString(3, vo.getbTitle());
			psmt.setString(4, vo.getbContent());
			psmt.setDate(5, vo.getbDate());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 등록되었습니다. ");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

//수정
	public int update(BoardVO vo) {
		int n=0;
		String sql="UPDATE board SET bContent=? WHERE bId=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbContent());
			psmt.setInt(2, vo.getbId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

//삭제
	public int delete(BoardVO vo) {
		int n=0;
		String sql = "DELETE FROM board WHERE bid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 삭제되었습니다. ");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	
	
	private void close() {								//close 객체
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

private void hitCount(int hit) { 	//조회수 증가 메소드
	String sql = "update board set bhit = bhit + 1 where bid=?";
	try {
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, hit);
		int n = psmt.executeUpdate();		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close();
	}
}
	
	
	
}
