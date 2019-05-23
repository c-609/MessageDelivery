package cn.tiger.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MenuRoleMapper {
	Integer authorizationForMenu(@Param("roleId") Integer roleId ,@Param("menuIds") Integer[] menuIds);
	
	Integer deleteMenuPermissions(@Param("roleId") Integer roleId);
}
