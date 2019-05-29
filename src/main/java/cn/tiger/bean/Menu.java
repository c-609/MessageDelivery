package cn.tiger.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Menu {
	private Integer menuId;
	private String name;
	private String permission;//菜单权限标识
	private String path;//前段url
	private Integer parentId;
	private String icon;
	private String component;//vue 页面
	private Integer sort;//排序值
	private char keepAlive;//0-开启 1-关闭
	private char type;//菜单类型 0-菜单 1-按钮
	private Date createTime;
	private Date updateTime;
	private char delFlag;//逻辑删除标记 0-正常 1-删除
	private Integer operatorId;
	
    
	private List<Role> roles;
}
