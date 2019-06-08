package cn.tiger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.tiger.bean.DeptUser;
import cn.tiger.security.util.SecurityUtils;
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
	@Autowired
	DeptUserService deptUserService;

	/**
	 * 根据角色ids获取角色列表
	 * @param ids 角色id
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

	/**
	 * 根据部门用户关系获取角色列表
	 * @return
	 */
	public List<Role> listByDeptUser(DeptUser deptUser) {
		List<DeptUser> deptUserList = deptUserService.getDeptUser(deptUser);
//		deptUser.setUserId(SecurityUtils.getUser().getId());
		List<Integer> roleList = new ArrayList<>(deptUserList.size());
		roleList.add(deptUserList.iterator().next().getRoleId());
		return listByRids(roleList.toArray(new Integer[roleList.size()]));
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
