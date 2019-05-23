package cn.tiger.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tiger.RightsManageApplicationTest;
import cn.tiger.bean.Dept;
import cn.tiger.bean.Menu;
import cn.tiger.bean.Student;
import cn.tiger.bean.Teacher;

public class TeacherServiceTest extends RightsManageApplicationTest{
	@Autowired
	TeacherService teacherService;
	@Test
	public void testGetAllTeacher() {
		List list  = teacherService.getAllTeacher();
		System.out.println(list);
	}
	@Test
	public void testGetTeacherPage() {
		List list  = teacherService.getTeacherPage(0,2);
		System.out.println(list);
	}
	
	@Test
	public void testAddTeacher() {
		Teacher teacher = new Teacher();
		teacher.setUserId(5);
		teacher.setName("test");
		teacher.setGender("男");
		Integer i = teacherService.addTeacher(teacher);
		System.out.println(i);
	}
	
	@Test
	public void testUpdateTeachert() {
		Teacher teacher = new Teacher();
		teacher.setUserId(5);
		teacher.setName("test1111");
		teacher.setGender("男");
		teacher.setPhone("987654321");
		Integer i = teacherService.updateTeacher(teacher);
		System.out.println(i);
	}
	@Test
	public void testDeleteTeacher() {
		Integer i = teacherService.deleteTeacherByTeacherId(5);
		System.out.println(i);
	}
	
}
