package cn.tiger.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthorizeUserAndGroupsMapper {
	Integer addPermissionsForUsers(@Param("userId") Integer userId,@Param("roleIds") Integer[] roleIds);
	
	Integer deleteUserPermissions(@Param("userId") Integer userId);
	
	Integer addPermissionsForGroups(@Param("groupId") Integer groupId,@Param("roleIds") Integer[] roleIds);
	
	Integer deleteGroupPermissions(@Param("groupId") Integer groupId);
}
