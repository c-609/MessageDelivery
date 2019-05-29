package cn.tiger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tiger.bean.Menu;
import cn.tiger.mapper.MenuMapper;
import cn.tiger.mapper.MenuRoleMapper;

@Service
@Transactional
public class MenuService {
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	MenuRoleMapper menuRoleMapper;

	//为菜单授权
	public Integer authorizationForMenu(Integer[] menuIds,Integer roleId) {
		menuRoleMapper.deleteMenuPermissions(roleId);
		return menuRoleMapper.authorizationForMenu(roleId, menuIds);
	}
	
	public List<Menu> getMenuList(){
		return menuMapper.findMenuList();
	}
	
	public List<Menu> getMenuByUserId(Integer uId){
		return menuMapper.findMenuByUserId(uId);
	}
	
	public List<Menu> getMenuByRoleId(Integer rId){
		return menuMapper.findMenuByRoleId(rId);
	}
	
	public Integer addMenu(Menu menu) {
		return menuMapper.addMenu(menu);
	}
	
	public Integer updateMenu(Menu menu) {
		return menuMapper.updateMenu(menu);
	}
	
	public Integer deleteMenuById(Integer mId) {
		return menuMapper.deleteMenuById(mId);
	}
}
