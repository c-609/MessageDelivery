package cn.tiger.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserTypesAndRoles {
	Integer[] findUserTypesByUserid(@Param("uId") Integer uId);
	

}
