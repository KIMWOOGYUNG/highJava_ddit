package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.vo.MemberVO;


/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서
 * Service에 전달하는 DAO의 interface
 * 
 * @author SEM-PC
 *
 */
public interface IMemberDao {

	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param memVo DB에 inert할 자료가 저장된 MemberVO객체
	 * @return DB작업 성공 : 1, 실패 : 0
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * @param memId 삭제할 회원ID
	 * @return 작업 성공 : 1, 실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * 하나의 MemberVO자료를 이용하여 회원 정보를 update하는 메서드
	 * @param memVo 수정할 정보가 저장된 MemverVO객체
	 * @return 작업 성공 : 1, 실패 : 0
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * 하나의 MemberVO자료를 이용하여 회원 정보를 update하는 메서드
	 * @param memVo 수정할 정보가 저장된 MemverVO객체
	 * @return 작업 성공 : 1, 실패 : 0
	 */
	public int updateMember(Map<String, String> paramMap);
	
	/**
	 * Map의 정보를 이용하여 회원정보를 수정하는 메서드
	 * @param paramMap 수정할 정보가 저장된 Map객체
	 * @return 검색된 회원 수
	 */
	public int getMemberCount(String memId);
	
	/**
	 * 전체 회원정보를 DB에서 가져와 각각의 정보는 MemberVO에 담고, 
	 * 이 MemberVO객체를 List에 넣어서 반환하는 메서드
	 * @return 전체 회원정보(MemberVO객체)가 저장된 List객체
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 검색할 컬럼명과 검색할 단어가 저장된 Map을 매개변수로 받아서 해당 데이터를 검색하여 List로 반환하는 메서드
	 * @param searchMap 검색할 컬럼명과 검색할 단어가 저장된 Map객체
	 * @return 검색결과를 List에 담아서 반환한다.
	 */
	public List<MemberVO> getSearchMember(Map<String, String> searchMap);

	/**
	 * 전체 레코드수를 반환하는 메서드
	 * @return 전체 레코드수
	 */
	public int getAllMemberCount();
	
	/**
	 * Map에 설정된 start번째 부터 end번째 까지의 데이터를 가져오는 메서드
	 * @param pageMap 시작(start)번호와 끝(end)번호가 저장된 Map객체
	 * @return 검색된 데이터의 List객체
	 */
	public List<MemberVO> getPagingMemberList(Map<String, Integer> pageMap);
}









