package kr.or.ddit.student.service;

import java.util.List;

import kr.or.ddit.student.dao.IStudentDao;
import kr.or.ddit.student.dao.StudentDaoImpl;
import kr.or.ddit.student.vo.StudentVO;

public class StudentServiceImpl implements IStudentService{
	private static StudentServiceImpl service;
	
	private IStudentDao dao;
	
	private StudentServiceImpl() {
		dao = StudentDaoImpl.getInstance();
	}
	
	public static StudentServiceImpl getInstance() {
		if(service == null) service = new StudentServiceImpl();
		return service;
	}
	
	@Override
	public List<StudentVO> getAllStudent() {
		return dao.getAllStudent();
	}

	@Override
	public List<StudentVO> searchStudent(String std_name) {
		return dao.searchStudent(std_name);
	}

	@Override
	public int addStudent(StudentVO stdVo) {
		return dao.addStudent(stdVo);
	}
	
}
