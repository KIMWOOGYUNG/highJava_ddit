package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDao {
	
	/**
	 * 파라미터로 넘어온 BoardVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param boardVo DB에 insert할 자료가 저장된 BoardVO객체
	 * @return DB작업 성공 : 1, 실패 : 0
	 */
	public int insertBoard(BoardVO boardVo);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글을 삭제하는 메서드
	 * @param board_no 삭제할 게시글No
	 * @return 작업 성공 : 1, 실패 : 0
	 */
	public int deleteBoard(int board_no);
	
	/**
	 * 수정할 자료가 저장된 BoardVO객체를 매개변수로 받아서 해당 자료를 update하는 메서드
	 * @param boardVo update할 값이 저장된 BoardVO객체
	 * @return 작업 성공 : 1, 실패 : 0
	 */
	public int updateBoard(BoardVO boardVo);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글을 정보 내용을 DB에서 가져와 반환하는 메서드
	 * @param board_no 가져올 게시글번호
	 * @return 해당 게시글 번호에 맞는 자료가 저장된 BoardVO객체 (해당 게시글이 없으면 null반환)
	 */
	public BoardVO getShowBoard(int board_no);
	
	/**
	 * 전체 게시글정보를 DB에서 가져와 각각의 정보는 BoardVO에 담고, 
	 * 이 BoardVO객체를 List에 넣어서 반환하는 메서드
	 * @return 전체 게시글정보(BoardVO객체)가 저장된 List객체
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 게시글 제목을 매개변수로 받아서 해당 게시글들을 가져와 VO 객체 List에 담아서 반환하는 메서드
	 * @param board_title 검색할 게시글 제목 
	 * @return 검색결과를 List에 담아서 반환한다.
	 */
	public List<BoardVO> getSearchBoard(String board_title);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글의 조회수를 1 증가 시키는 메서드
	 * @param board_no 게시글 번호
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int setCountIncrement(int board_no);
}
