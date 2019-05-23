package cn.tiger.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tiger.RightsManageApplicationTest;
import cn.tiger.bean.Dept;
import cn.tiger.bean.Menu;

public class DeptServiceTest extends RightsManageApplicationTest{
	@Autowired
	DeptService deptService;
	@Test
	public void testGetDeptList() {
		List list = deptService.getDeptList();
		System.out.println(list);
	}
	@Test
	public void testAddDept() {
		Dept dept = new Dept();
		dept.setName("test");
		dept.setParentId(16);
		Integer i = deptService.addDept(dept);
		System.out.println(i);
	}
	@Test
	public void testUpdateDept() {
		Dept dept = new Dept();
		dept.setId(17);
		dept.setName("test11");
		dept.setStatus(1);
		Integer i = deptService.updateDept(dept);
		System.out.println(i);
	}
	@Test
	public void testDeleteDept() {
		Integer i = deptService.deleteDeptById(17);
		System.out.println(i);
	}
	@Test
	public void testGetStudentByDeptid() {
		List list = deptService.getStudentByDeptid(12);
		System.out.println(list);
	}
	@Test
	public void testGetTeacherByDeptid() {
		List list = deptService.getTeacherByDeptid(16);
		System.out.println(list);
	}
}
