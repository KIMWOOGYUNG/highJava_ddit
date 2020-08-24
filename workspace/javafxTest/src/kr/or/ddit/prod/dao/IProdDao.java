package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.vo.LprodVO;
import kr.or.ddit.prod.vo.ProdVO;

public interface IProdDao {
	/**
	 * 전체 제품정보를 DB에서 가져와 각각의 정보는 ProdVO에 담고,
	 * 이 ProdVO객체를 List에 넣어서 반환하는 메서드
	 * @param prod_lgu 검색할 상품 분류 코드
	 * @return 검색된 상품 목록 List
	 */
	public List<ProdVO> getAllProd(String prod_lgu);
	
	/**
	 * 전체 제품정보를 DB에서 가져와 각각의 정보는 ProdVO에 담고,
	 * 이 ProdVO객체를 List에 넣어서 반환하는 메서드
	 * @return 전체 제품분류정보(LprodVO객체)가 저장된 List객체
	 */
	public List<LprodVO> getAllLprod();
	
	/**
	 * 상품코드를 매개변수로 받아 해당 상품을 검색해서 List로 반환하는 메서드
	 * @param prod_id 검색할 상품코드
	 * @return 검색된 상품 목록 List
	 */
	public List<ProdVO> tableView(String prod_id);
}
