package cn.tiger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tiger.bean.Student;
import cn.tiger.mapper.StuMapper;

@Service
public class StuService {
	@Autowired
	StuMapper stuMapper;
	@Autowired
	DeptService deptService;;
	
	
	public List<Student> getAllStudent(){
		return stuMapper.findAllStudent();
	}
	
	public List<Student> getStudentPage(Integer currPage,Integer pageSize){
		return stuMapper.findStudentPage(currPage, pageSize);
	}
	
	public Integer addStudent(Student student,Integer[] deptIds) {
		Integer i = stuMapper.addStudent(student);
		if(i==0)
			return deptService.addDeptForUsers(student.getUserId(), deptIds);
		return 0;
	}
	
	public Integer updateStudent(Student student ,Integer[] deptIds) {
		deptService.updateDeptForUsers(student.getUserId(), deptIds);
		return stuMapper.updateStudent(student);
	}
	
	public Integer deleteStudentById(Integer stuId) {
		return stuMapper.deleteStudentById(stuId);
	}
}
