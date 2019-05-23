package cn.tiger.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tiger.RightsManageApplicationTest;
import cn.tiger.bean.Dept;
import cn.tiger.bean.Menu;
import cn.tiger.bean.Student;

public class StuServiceTest extends RightsManageApplicationTest{
	@Autowired
	StuService stuService;
	@Test
	public void testGetAllStudent() {
		List list  = stuService.getAllStudent();
		System.out.println(list);
	}
	@Test
	public void testGetStudentPage() {
		List list  = stuService.getStudentPage(0,2);
		System.out.println(list);
	}
	
	@Test
	public void testAddStudent() {
		Student stu=new Student();
		Integer[] deptIds = new Integer[] {15};
		stu.setUserId(5);
		stu.setName("test");
		stu.setAge(11);
		Integer i = stuService.addStudent(stu,deptIds);
		System.out.println(i);
	}
	
	@Test
	public void testUpdateStudent() {
		Student stu=new Student();
		Integer[] deptIds = new Integer[] {15,16};
		stu.setUserId(5);
		stu.setName("test1111");
		stu.setPhone("12345674");
		stu.setAge(111);
		Integer i = stuService.updateStudent(stu,deptIds);
		System.out.println(i);
	}
	@Test
	public void testDeleteStudent() {
		Integer i = stuService.deleteStudentById(5);
		System.out.println(i);
	}
	
}
