package com.saltlux.assembly.student;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.saltlux.assembly.vos.Student;

@Mapper
public interface StudentDAO {
	
	@Select("select datetime('now', 'localtime')")
	public String getCurrentTimestamp();

	@Select("select * from student")
	public List<Student> getStudentAll();

	@Insert("INSERT INTO student (num, name) VALUES((SELECT IFNULL(MAX(num) + 1, 1) FROM student), datetime('now', 'localtime'))")
	public int insertStudent();

	@Update("UPDATE student SET name = datetime('now', 'localtime') WHERE num = #{num}")
	public int updateStudent(Student student);

	@Delete("delete from student where num = #{num}")
	public int deleteStudent(Student student);
}
