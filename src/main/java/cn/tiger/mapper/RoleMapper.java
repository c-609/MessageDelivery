package cn.tiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.tiger.bean.Role;
import cn.tiger.bean.User;

@Mapper
public interface RoleMapper {
	List<Role> findAllRole();
	
	Integer addRole(Role role);
	
	Integer updateRole(Role role);
	
	Integer deleteRoleById(@Param("rId") Integer rId);
	
	List<User> findUserByRoleId(@Param("rId") Integer rId);
}
