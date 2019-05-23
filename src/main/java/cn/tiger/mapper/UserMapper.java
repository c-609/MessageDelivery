package cn.tiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.tiger.bean.Role;
import cn.tiger.bean.User;

@Mapper
public interface UserMapper {
	User loginAuthenticationByUsername(@Param("uName") String uName);
	
	List<User> findAllUser();
	
	User findUserByUserid(@Param("uId")Integer uId);
	
	User findUserByUsername(@Param("uName") String uName);
	
	//获取用户组id
	//Integer[] findUserTypeByUserid(@Param("uId") Integer uId);
	//获取用户所有角色
	//List<Role> findUserRoleByUserid(@Param("uId")Integer uId);
	
	//将用户分组
	Integer groupUsers(Integer userId,Integer groupId);
	
	Integer updateUser(User user);
	
	Integer deleteUserById(@Param("uId") Integer uId);
	
	Integer addUser(@Param("user") User user);
	
	Integer addRoleForUser(@Param("uId") Integer uId,@Param("rIds") List<Integer> rIds);
	
}
