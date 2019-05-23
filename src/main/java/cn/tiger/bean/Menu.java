package cn.tiger.bean;

import java.util.Date;
import java.util.List;

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
    
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public char getKeepAlive() {
		return keepAlive;
	}
	public void setKeepAlive(char keepAlive) {
		this.keepAlive = keepAlive;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public char getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(char delFlag) {
		this.delFlag = delFlag;
	}
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	
}
