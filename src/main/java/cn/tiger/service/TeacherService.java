package cn.tiger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tiger.bean.Teacher;
import cn.tiger.mapper.TeacherMapper;

@Service
public class TeacherService {
	@Autowired
	TeacherMapper teacherMapper;
	
	public List<Teacher> getAllTeacher(){
		return teacherMapper.findAllTeacher();
	}
	
	public List<Teacher> getTeacherPage(Integer currPage,Integer pageSize){
		return teacherMapper.findTeacherPage(currPage, pageSize);
	}
	
	public Integer addTeacher(Teacher teacher) {
		return teacherMapper.addTeacher(teacher);
	}
	
	public Integer updateTeacher(Teacher teacher) {
		return teacherMapper.updateTeacher(teacher);
	}
	
	public Integer deleteTeacherByTeacherId(Integer teacherId) {
		return teacherMapper.deleteTeacherByTeacherid(teacherId);
	}
}
