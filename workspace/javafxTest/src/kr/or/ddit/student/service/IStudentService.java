package kr.or.ddit.student.service;

import java.util.List;

import kr.or.ddit.student.vo.StudentVO;

public interface IStudentService {
	/**
	 * 전체 학생정보를 DB에서 가져와 각각의 정보는 StudentVO에 담고,
	 * 이 StudentVO객체를 List에 넣어서 반환하는 메서드
	 * @return 전체 학생정보(StudentVO객체)가 저장된 List객체
	 */ 
	public List<StudentVO> getAllStudent();
	
	/**
	 * 학생이름을 매개변수로 받아 해당 학생을 검색해서 List로 반환하는 메서드
	 * @param std_name 검색할 학생이름
	 * @return 검색된 학생 목록 List
	 */
	public List<StudentVO> searchStudent(String std_name);
	
	/**
	 * StudentVO를 매개변수로 받아 해당 학생을 DB에 저장하는 메서드
	 * @param stdVo 저장할 StudentVO객체
	 * @return DB작업 성공 : 1, 실패 : 0
	 */
	public int addStudent(StudentVO stdVo);
}
