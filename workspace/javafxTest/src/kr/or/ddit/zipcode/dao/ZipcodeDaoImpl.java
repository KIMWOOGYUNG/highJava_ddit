package kr.or.ddit.zipcode.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.BuildedSqlMapClient;
import kr.or.ddit.zipcode.vo.ZipcodeVo;

public class ZipcodeDaoImpl implements IzipcodeDao{
	private static ZipcodeDaoImpl dao;
	private SqlMapClient smc;
	
	private ZipcodeDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}

	public static ZipcodeDaoImpl getInstance() {
		if(dao == null) dao = new ZipcodeDaoImpl();
		return dao;
	}
	
	@Override
	public List<ZipcodeVo> searchDong(String dong) {
		int cnt = 0;
		List<ZipcodeVo> zcList = null;
		try {
			zcList = smc.queryForList("zipcode.searchDong",dong);
		} catch (SQLException e) {
			zcList = null;
			e.printStackTrace();
		}
		return zcList;
	}

	@Override
	public List<ZipcodeVo> searchZipcode(String zipcode) {
		int cnt = 0;
		List<ZipcodeVo> zcList = null;
		try {
			zcList = smc.queryForList("zipcode.searchZipcode",zipcode);
		} catch (SQLException e) {
			zcList = null;
			e.printStackTrace();
		}
		return zcList;
	}

}
