package cn.tiger.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tiger.RightsManageApplicationTest;
import cn.tiger.bean.User;

public class UserServiceTest extends RightsManageApplicationTest{
	@Autowired
    UserService userService;
	
	 @Test
	    public void testlLginAuthenticationByUsername() {
	        User user= userService.loginAuthenticationByUsername("student1");
	        System.out.println(user);
	    }
	
    @Test
    public void testGetAllUesr() {
        List userList = userService.getAllUser();
        System.out.println(userList);
    }
    
    @Test
    public void testGetUserByUserid() {
        User user = userService.getUserByUserid(1);
        System.out.println(user);
    }
    @Test
    public void testGetUesrByUsername() {
       User user = userService.getUserByUsername("student1");
        System.out.println(user);
    }
    
    
    @Test
    public void testUpdateUser() {
       User user = new User();
       user.setId(1);
       user.setUsername("student1");
       user.setPassword("456");
       Integer i = userService.updateUser(user);
        System.out.println(i);
    }
    @Test
    public void testDeleteUserById() {
       Integer i = userService.deleteUserById(5);
        System.out.println(i);
    }
    @Test
    public void testAddUser() {
    	User user = new User();
        user.setUsername("ii");
        user.setPassword("456");
        System.out.println(user);
        Integer i = userService.addUser(user);
         System.out.println(i);
    }
}
