package cn.tiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.tiger.bean.Dept;
import cn.tiger.bean.Student;
import cn.tiger.bean.Teacher;
import cn.tiger.bean.User;

@Mapper
public interface DeptMapper {
	List<Dept> findDeptList();
	
	Integer addDept(Dept dept);
	
	Integer updateDept(Dept dept);
	
	Integer deleteDeptById(@Param("dId") Integer dId);
	
	Integer addDeptForUsers(@Param("userId") Integer userId,@Param("deptIds") Integer[] deptIds);
	
	Integer deleteDeptUsersByUserid(@Param("userId") Integer userId);
	
	List<Student> findStudentByDeptid(@Param("deptId")Integer deptId);
	
	List<Teacher> findTeacherByDeptid(@Param("deptId")Integer deptId);
}
