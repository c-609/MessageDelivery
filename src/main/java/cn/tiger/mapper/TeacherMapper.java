package cn.tiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.tiger.bean.Teacher;

@Mapper
public interface TeacherMapper {
	List<Teacher> findAllTeacher();
	
	List<Teacher> findTeacherPage(@Param("currPage") Integer currPage,@Param("pageSize") Integer pageSize);
	
	Integer addTeacher(Teacher teacher);
	
	Integer updateTeacher(Teacher teacher);
	
	Integer deleteTeacherByTeacherid(@Param("teacherId") Integer teacherId);
}
