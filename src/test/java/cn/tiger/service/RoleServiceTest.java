package cn.tiger.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tiger.RightsManageApplicationTest;
import cn.tiger.bean.Role;
import cn.tiger.bean.User;


public class RoleServiceTest extends RightsManageApplicationTest{
	@Autowired
	RoleService roleService;


	@Test
	public void testGetAllRole() {
		List<Role> list = roleService.getAllRole();
		System.out.println(list);
	}
	@Test
	public void testAddRole() {
		Role role = new Role();
		role.setName("test");
		role.setAlias("ROLE_test");
		role.setOperatorId(2);
		Integer i = roleService.addRole(role);
		System.out.println(i);
	}
	@Test
	public void testUpdateRole() {
		Role role = new Role();
		role.setId(3);
		role.setName("test111");
		role.setAlias("ROLE_test");
		role.setOperatorId(1);
		Integer i = roleService.updateRole(role);
		System.out.println(i);
	}
	@Test
	public void testDeleteRole() {
		Integer i = roleService.deleteRoleById(3);
		System.out.println(i);
	}
	@Test
	public void tesGetUserByRoleId() {
		List<User> list = roleService.getUserByRoleId(1);
		System.out.println(list);
	}
}
