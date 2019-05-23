package cn.tiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.tiger.bean.Student;

@Mapper
public interface StuMapper {
	
	List<Student> findAllStudent();
	
	List<Student> findStudentPage(@Param("currPage") Integer currPage,@Param("pageSize") Integer pageSize);
	
	Integer addStudent(Student student);
	
	Integer updateStudent(Student student);
	
	Integer deleteStudentById(@Param("stuId") Integer stuId);
	
}
