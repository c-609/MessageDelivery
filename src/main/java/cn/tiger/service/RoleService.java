package cn.tiger.service;

import java.util.ArrayList;
import java.util.Arrays;
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

	/**
	 * 获取角色列表
	 * @param ids
	 * @return
	 */
	public List<Role> listByRids(Integer[] ids) {
		roleMapper.selectById(ids[0]);
		List<Role> roleList = new ArrayList<>();
		Arrays.stream(ids).forEach(id -> {
			roleList.add(roleMapper.selectById(id));
		});
		return roleList;
	}

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
