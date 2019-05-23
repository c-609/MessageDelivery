package cn.tiger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tiger.bean.User;

@Service
public class RegisterService {
	@Autowired
	UserService userService;
	@Autowired
	StuService stuService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	DeptService deptService;
	
	public Integer Register(User user ,Integer groupId) {
		userService.addUser(user);
		return this.groupUsers(user.getId(),groupId);
	}
	
	//多身份注册
	public Integer Register1(Integer userId,Integer groupId) {
		return this.groupUsers(userId, groupId);
	}
	
	//将用户分组
	public Integer groupUsers(Integer userId,Integer groupId) {
		return userService.groupUsers(userId, groupId);	
	}
	
}
