package basic.mvc.service;

import java.util.List;
import java.util.Map;

import basic.mvc.dao.IMemberDao;
import basic.mvc.dao.MemberDaoImpl;
import basic.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private static MemberServiceImpl service;
	
	private IMemberDao dao;  // DAO객체가 저장될 변수 선언
	//생성자
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance(){
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	

	@Override
	public int insertMember(MemberVO memVo) {
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return dao.updateMember(memVo);
	}

	@Override
	public int getMemberCount(String memId) {
		return dao.getMemberCount(memId);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int updateMember(Map<String, String> paramMap) {
		return dao.updateMember(paramMap);
	}

	@Override
	public List<MemberVO> getSearchMember(Map<String, String> searchMap) {
		return dao.getSearchMember(searchMap);
	}

}