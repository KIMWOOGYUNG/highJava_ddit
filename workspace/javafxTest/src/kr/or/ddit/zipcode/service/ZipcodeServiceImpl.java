package kr.or.ddit.zipcode.service;

import java.util.List;

import kr.or.ddit.zipcode.dao.IzipcodeDao;
import kr.or.ddit.zipcode.dao.ZipcodeDaoImpl;
import kr.or.ddit.zipcode.vo.ZipcodeVo;

public class ZipcodeServiceImpl implements IzipcodeService{
	private static ZipcodeServiceImpl service;
	
	private IzipcodeDao dao;
	
	private ZipcodeServiceImpl() {
		dao = ZipcodeDaoImpl.getInstance();
	}
	
	public static ZipcodeServiceImpl getInstance() {
		if(service == null) service = new ZipcodeServiceImpl();
		return service;
	}

	@Override
	public List<ZipcodeVo> searchDong(String dong) {
		return dao.searchDong(dong);
	}

	@Override
	public List<ZipcodeVo> searchZipcode(String zipcode) {
		return dao.searchZipcode(zipcode);
	}
	

}
