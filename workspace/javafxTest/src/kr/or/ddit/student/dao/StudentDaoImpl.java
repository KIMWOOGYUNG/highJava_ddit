package kr.or.ddit.student.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.student.vo.StudentVO;
import kr.or.ddit.util.BuildedSqlMapClient;

public class StudentDaoImpl implements IStudentDao{

	private static StudentDaoImpl dao;
	private SqlMapClient smc;
	
	//생성자
	private StudentDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static StudentDaoImpl getInstance() {
		if(dao == null) dao = new StudentDaoImpl();
		return dao;
	}

	@Override
	public List<StudentVO> getAllStudent() {
		List<StudentVO> studentList = null;
		try {
			studentList = smc.queryForList("student.getAllStudent");
		} catch (SQLException e) {
			studentList = null;
			e.printStackTrace();
		}
		return studentList;
	}


	@Override
	public List<StudentVO> searchStudent(String std_name) {
		List<StudentVO> studentList = null;
		try {
			studentList = smc.queryForList("student.searchStudent");
		} catch (SQLException e) {
			studentList = null;
			e.printStackTrace();
		}
		return studentList;
	}


	@Override
	public int addStudent(StudentVO stdVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("student.insertStudent",stdVo);
			if(obj == null) {
				cnt = 1;
			}else {
				cnt = 0;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

}
