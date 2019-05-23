package cn.tiger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tiger.bean.User;
import cn.tiger.mapper.UserMapper;

@Service
@Transactional
public class UserService {
		@Autowired
		UserMapper userMapper;
		
		public User loginAuthenticationByUsername(String username){
			return userMapper.loginAuthenticationByUsername(username);
		}
		
		public List<User> getAllUser() {
			return userMapper.findAllUser();
		}
		
		public User getUserByUserid(Integer userId) {
			return userMapper.findUserByUserid(userId);
		}
		
		public User getUserByUsername(String uName){
			return userMapper.findUserByUsername(uName);
		}
		
		
		public Integer groupUsers(Integer userId,Integer groupId) {
			return userMapper.groupUsers(userId, groupId);
		}
		
		public Integer updateUser(User user) {
			return userMapper.updateUser(user);
		}
		public Integer deleteUserById(Integer uId) {
			return userMapper.deleteUserById(uId);
		}
		public Integer addUser(User user) {
			return userMapper.addUser(user);
		}
}
