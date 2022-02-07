package com.saltlux.assembly.student;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saltlux.assembly.vos.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDao;
	
	public List<Student> getStudentList() {
		return studentDao.getStudentAll();
	}
	
	public String getCurrentTimestamp() {
		return studentDao.getCurrentTimestamp();
	}

	public Map<String, Object> insertStudent() {
		Map<String, Object> resultMap = new ConcurrentHashMap<>();
		
		int result = studentDao.insertStudent();
		
		if(result > 0) {
			resultMap.put("result", true);
			resultMap.put("msg", "입력 성공.");
		} else {
			resultMap.put("result", false);
			resultMap.put("msg", "입력 실패. 학생 번호를 확인해주세요.");
		}
		
		return resultMap;
	}

	public Map<String, Object> updateStudent(Student student) {
		Map<String, Object> resultMap = new ConcurrentHashMap<>();
		
		int result = studentDao.updateStudent(student);
		
		if(result > 0) {
			resultMap.put("result", true);
			resultMap.put("msg", "수정 성공.");
		} else {
			resultMap.put("result", false);
			resultMap.put("msg", "수정 실패. 학생 번호를 확인해주세요.");
		}
		
		return resultMap;
	}

	public Map<String, Object> deleteStudent(Student student) {
		Map<String, Object> resultMap = new ConcurrentHashMap<>();
		
		int result = studentDao.deleteStudent(student);
		
		if(result > 0) {
			resultMap.put("result", true);
			resultMap.put("msg", "삭제 성공.");
		} else {
			resultMap.put("result", false);
			resultMap.put("msg", "삭제 실패. 학생 번호를 확인해주세요.");
		}
		
		return resultMap;
	}
}
