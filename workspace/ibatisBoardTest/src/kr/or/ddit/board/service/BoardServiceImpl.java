package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	private static BoardServiceImpl service;
	
	private IBoardDao dao;
	//생성자
	private BoardServiceImpl(){
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance(){
		if(service == null) service = new BoardServiceImpl();
		return service; 
	}
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		return dao.insertBoard(boardVo);
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return dao.getAllBoard();
	}

	@Override
	public BoardVO getShowBoard(int board_no) {
		return dao.getShowBoard(board_no);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		return dao.updateBoard(boardVo);
	}

	@Override
	public int deleteBoard(int board_no) {
		return dao.deleteBoard(board_no);
	}

	@Override
	public List<BoardVO> getSearchBoard(String board_title) {
		return dao.getSearchBoard(board_title);
	}

	@Override
	public int setCountIncrement(int board_no) {
		return dao.setCountIncrement(board_no);
	}
	

}
