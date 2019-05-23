package cn.tiger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tiger.bean.Role;
import cn.tiger.bean.User;
import cn.tiger.mapper.RoleMapper;

@Service
@Transactional
public class RoleService {
	@Autowired
	RoleMapper roleMapper;
	
	public List<Role> getAllRole(){
		return roleMapper.findAllRole();
	}
	
	public Integer addRole(Role role) {
		return roleMapper.addRole(role);
	}
	
	public Integer updateRole(Role role) {
		return roleMapper.updateRole(role);
	}
	
	public Integer deleteRoleById(Integer rId) {
		return roleMapper.deleteRoleById(rId);
	}
	
	public List<User> getUserByRoleId(Integer rId){
		return roleMapper.findUserByRoleId(rId);
	}
}
