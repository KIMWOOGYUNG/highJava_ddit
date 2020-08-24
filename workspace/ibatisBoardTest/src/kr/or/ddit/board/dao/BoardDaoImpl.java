package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.BuildedSqlMapClient;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BoardDaoImpl implements IBoardDao{
	
	//싱글톤
	private SqlMapClient smc;
	private static BoardDaoImpl dao;
	
	private BoardDaoImpl(){
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	public static BoardDaoImpl getInstance(){
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		int cnt = 0;
		try {
			//insert할때는 object로 반환하기 때문에 cnt로 바로 담아주면 안됨.
			Object obj = smc.insert("jdbcBoard.insertBoard",boardVo);
			if(obj == null){
				cnt = 1;
			}else{
				cnt = 0;
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoard() {		
		List<BoardVO> boardList = null;
		
		try {
			boardList = smc.queryForList("jdbcBoard.getAllBoard");
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		} 
		return boardList;
	}

	@Override
	public BoardVO getShowBoard(int board_no) {

		BoardVO boardVo = null;
		try {
			boardVo = (BoardVO) smc.queryForObject("jdbcBoard.getShowBoard",board_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardVo;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {

		int cnt = 0;
		try {
			cnt = smc.update("jdbcBoard.updateBoard",boardVo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int deleteBoard(int board_no) {

		int cnt = 0;
		try {
			cnt = smc.delete("jdbcBoard.deleteBoard",board_no);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public List<BoardVO> getSearchBoard(String board_title) {
		List<BoardVO> boardList = null;
		
		try {
			boardList = smc.queryForList("jdbcBoard.getSearchBoard",board_title);
			
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	
	@Override
	public int setCountIncrement(int board_no) {
		int cnt = 0;
		
		try {
			cnt = smc.update("jdbcBoard.setCountIncrement",board_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
