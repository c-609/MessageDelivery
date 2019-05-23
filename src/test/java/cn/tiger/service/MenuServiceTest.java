package cn.tiger.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tiger.RightsManageApplicationTest;
import cn.tiger.bean.Menu;

public class MenuServiceTest extends RightsManageApplicationTest{
	@Autowired
    MenuService menuService;
	
	@Test
	public void testAuthorizationForMenu() {
		Integer[]  menuIds = new Integer[] {1000,1100}; 
		Integer i = menuService.authorizationForMenu(menuIds, 1);
		System.out.println(i);
	}
	
    @Test
    public void testGetMenuList() {
        List list = menuService.getMenuList();
        System.out.println(list);
    }
    
    @Test
    public void testGetMenuByUserId() {
        List list = menuService.getMenuByUserId(4);
        System.out.println(list);
    }
    @Test
    public void testGetMenuRoleId() {
        List list = menuService.getMenuByRoleId(1);
        System.out.println(list);
    }
    @Test
    public void testAddMenu() {
    	Menu menu = new Menu();
    	menu.setMenuId(1111);
    	menu.setName("test");
        Integer i = menuService.addMenu(menu);
        System.out.println(i);
    }
    @Test
    public void testUpdateMenu() {
    	Menu menu = new Menu();
    	menu.setMenuId(1111);
    	menu.setName("test11");
    	menu.setPath("/test");
        Integer i = menuService.updateMenu(menu);
        System.out.println(i);
    }
    @Test
    public void testDeleteMenuById() {
        Integer i = menuService.deleteMenuById(1111);
        System.out.println(i);
    }
}
