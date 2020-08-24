package kr.or.ddit.zipcode.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.zipcode.dao.IzipcodeDao;
import kr.or.ddit.zipcode.dao.ZipcodeDaoImpl;
import kr.or.ddit.zipcode.vo.ZipcodeVo;

public class ZipcodeServiceImpl extends UnicastRemoteObject implements IzipcodeService{
	private static ZipcodeServiceImpl service;
	
	private IzipcodeDao dao;
	
	private ZipcodeServiceImpl() throws RemoteException{
		dao = ZipcodeDaoImpl.getInstance();
	}
	
	public static ZipcodeServiceImpl getInstance() {
		try {
			if(service == null) service = new ZipcodeServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;			
	}

	@Override
	public List<ZipcodeVo> searchDong(String dong) throws RemoteException{
		return dao.searchDong(dong);
	}

	@Override
	public List<ZipcodeVo> searchZipcode(String zipcode) throws RemoteException{
		return dao.searchZipcode(zipcode);
	}
	

}
