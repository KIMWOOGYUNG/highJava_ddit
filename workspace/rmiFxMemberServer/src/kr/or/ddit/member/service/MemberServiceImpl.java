
package kr.or.ddit.member.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl extends UnicastRemoteObject implements IMemberService {
	private static MemberServiceImpl service;
	
	private IMemberDao dao;  // DAO객체가 저장될 변수 선언
	//생성자
	private MemberServiceImpl() throws RemoteException{
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance(){
		try {
			if(service == null) service = new MemberServiceImpl();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}
	

	@Override
	public int insertMember(MemberVO memVo) throws RemoteException {
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) throws RemoteException {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) throws RemoteException {
		return dao.updateMember(memVo);
	}

	@Override
	public int getMemberCount(String memId) throws RemoteException {
		return dao.getMemberCount(memId);
	}

	@Override
	public List<MemberVO> getAllMember() throws RemoteException {
		return dao.getAllMember();
	}

	@Override
	public int updateMember(Map<String, String> paramMap) throws RemoteException {
		return dao.updateMember(paramMap);
	}

	@Override
	public List<MemberVO> getSearchMember(Map<String, String> searchMap) throws RemoteException {
		return dao.getSearchMember(searchMap);
	}
	
	@Override
	public int getAllMemberCount() throws RemoteException {
		return dao.getAllMemberCount();
	}

	@Override
	public List<MemberVO> getPagingMemberList(Map<String, Integer> pageMap) throws RemoteException {
		return dao.getPagingMemberList(pageMap);
	}
}
