package cn.tiger.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tiger.RightsManageApplicationTest;
import cn.tiger.bean.Menu;

public class AuthorizeUserAndGroupsServiceTest extends RightsManageApplicationTest{
	@Autowired
	AuthorizeUserAndGroupsService authorizeUserAndGroupsService;
	
	@Test
	public void testAuthorizeUsers() {
		Integer[]  roleIds = new Integer[] {1,2}; 
		Integer i = authorizeUserAndGroupsService.authorizeUsers(6, roleIds);
		System.out.println(i);
	}
	@Test
	public void testupdateUserPermissions() {
		Integer[]  roleIds = new Integer[] {1};
		Integer i = authorizeUserAndGroupsService.updateUserPermissions(6, roleIds);
		System.out.println(i);
	}
	
	@Test
	public void testAuthorizeGroups() {
		Integer[]  roleIds = new Integer[] {1}; 
		Integer i = authorizeUserAndGroupsService.authorizeGroups(1, roleIds);
		System.out.println(i);
	}
	@Test
	public void testupdateGroupPermissions() {
		Integer[]  roleIds = new Integer[] {2};
		Integer i = authorizeUserAndGroupsService.updateGroupPermissions(1, roleIds);
		System.out.println(i);
	}
	
}
