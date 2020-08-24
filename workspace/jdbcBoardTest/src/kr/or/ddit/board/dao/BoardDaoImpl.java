package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.util.DBUtil3;
import kr.or.ddit.board.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao{
	
	//싱글톤
	private static BoardDaoImpl dao;
	private BoardDaoImpl(){}
	public static BoardDaoImpl getInstance(){
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	
	//DB작업에 필요한 객체 변수 선언
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//사용한 자원을 반납하는 메서드
	public void disConnect(){
		if(rs != null) try{rs.close();}catch(SQLException e){}
		if(pstmt != null) try{pstmt.close();}catch(SQLException e){}
		if(stmt != null) try{stmt.close();}catch(SQLException e){}
		if(conn != null) try{conn.close();}catch(SQLException e){}
	}
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into jdbc_board (board_no, board_title, board_writer, board_content, board_date, board_cnt)"
						+ "values (seq_board.nextval, ?, ?, ?, sysdate, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_writer());
			pstmt.setString(3, boardVo.getBoard_content());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoard() {		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select board_no, board_title, board_writer, board_content, to_char(board_date, 'YYYY-MM-DD')board_date, board_cnt from jdbc_board";
			//select * 로 하지 않은 이유 : 날짜형 변환때문에!
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//반복문 안에서는 가져온 레코드 하나 하나를 VO객체에 매핑하고
			//이 VO객체를 List에 추가한다.
			while(rs.next()){
				BoardVO boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_content(rs.getString("board_content"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				
				boardList.add(boardVo);
			}
			
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return boardList;
	}

	@Override
	public BoardVO getShowBoard(int board_no) {

		BoardVO boardVo = null;
		try {
			conn = DBUtil3.getConnection();
			String sql = "select board_no, board_title, board_writer, board_content, to_char(board_date, 'YYYY-MM-DD') board_date, board_cnt from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_content(rs.getString("board_content"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return boardVo;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {

		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board set board_title = ?, board_content = ?, board_date = sysdate " + "where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_content());
			pstmt.setInt(3, boardVo.getBoard_no());
			
			cnt = pstmt.executeUpdate();
			System.out.println(cnt);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int board_no) {

		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> getSearchBoard(String board_title) {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select board_no, board_title, board_writer, board_content, to_char(board_date, 'YYYY-MM-DD')board_date, board_cnt from jdbc_board where board_title " + "like '%' || ? || '%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_title);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				BoardVO boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_content(rs.getString("board_content"));
				boardVo.setBoard_date(rs.getString("board_date"));
				
				boardList.add(boardVo);
			}
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return boardList;
	}
	
	@Override
	public int setCountIncrement(int board_no) {
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board set board_cnt = board_cnt + 1 where board_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}

}
