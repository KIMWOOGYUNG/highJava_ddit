package kr.or.ddit.zipcode.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.zipcode.vo.ZipcodeVo;

public interface IzipcodeService extends Remote{
	/**
	 * 동이름을 매개변수로 받아 해당 주소를 검색해서 List로 반환하는 메서드
	 * @param dong
	 * @return 검색된 주소 List
	 */
	public List<ZipcodeVo> searchDong(String dong) throws RemoteException;
	
	/**
	 * 우편번호를 매개변수로 받아 해당 주소를 검색해서 List로 반환하는 메서드
	 * @param zipcode
	 * @return 검색된 주소 List
	 */
	public List<ZipcodeVo> searchZipcode(String zipcode) throws RemoteException;
}
