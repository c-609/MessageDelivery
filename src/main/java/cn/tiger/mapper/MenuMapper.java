package cn.tiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.tiger.bean.Menu;

@Mapper
public interface MenuMapper {
	
	List<Menu> findMenuList();
	
	List<Menu> findMenuByUserId(@Param("uId")Integer uId);
	
	List<Menu> findMenuByRoleId(@Param("rId") Integer rId);
	
	Integer updateMenu(Menu menu);
	
	Integer addMenu(Menu menu);
	
	Integer deleteMenuById(@Param("mId") int mId);
}
