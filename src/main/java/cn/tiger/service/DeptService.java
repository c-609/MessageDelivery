package cn.tiger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tiger.bean.Dept;
import cn.tiger.bean.Student;
import cn.tiger.bean.Teacher;
import cn.tiger.bean.User;
import cn.tiger.mapper.DeptMapper;

@Service
public class DeptService {
	@Autowired
	DeptMapper deptMapper;
	
	public List<Dept> getDeptList(){
		return deptMapper.findDeptList();
	}
	
	public Integer addDept(Dept  dept) {
		return deptMapper.addDept(dept);
	}
	
	public Integer updateDept(Dept dept) {
		return deptMapper.updateDept(dept);
	}
	
	public Integer deleteDeptById(Integer dId) {
		return deptMapper.deleteDeptById(dId);
	}
	
	public Integer addDeptForUsers(Integer userId,Integer[] deptIds) {
		return deptMapper.addDeptForUsers(userId, deptIds);
	}
	
	public Integer updateDeptForUsers(Integer userId,Integer[] deptIds) {
		deptMapper.deleteDeptUsersByUserid(userId);
		return deptMapper.addDeptForUsers(userId, deptIds);
	}
	
	public List<Student> getStudentByDeptid(Integer deptId){
		return deptMapper.findStudentByDeptid(deptId);
	}
	
	public List<Teacher> getTeacherByDeptid(Integer deptId){
		return deptMapper.findTeacherByDeptid(deptId);
	}
}
