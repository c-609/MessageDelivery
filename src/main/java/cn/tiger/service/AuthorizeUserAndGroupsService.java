package cn.tiger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tiger.mapper.AuthorizeUserAndGroupsMapper;

@Service
public class AuthorizeUserAndGroupsService {
	@Autowired
	AuthorizeUserAndGroupsMapper authorizeUserAndGroupsMapper;
	
	//为用户授权
	public Integer authorizeUsers(Integer userId,Integer[] roleIds) {
		return authorizeUserAndGroupsMapper.addPermissionsForUsers(userId, roleIds);
	}
	
	public Integer updateUserPermissions(Integer userId,Integer[] roleIds) {
		authorizeUserAndGroupsMapper.deleteUserPermissions(userId);
		return authorizeUserAndGroupsMapper.addPermissionsForUsers(userId, roleIds);
	}
	
	//为用户组授权
	public Integer authorizeGroups(Integer groupId,Integer[] roleIds) {
		return authorizeUserAndGroupsMapper.addPermissionsForGroups(groupId, roleIds);
	}
	
	public Integer updateGroupPermissions(Integer groupId,Integer[] roleIds) {
		authorizeUserAndGroupsMapper.deleteGroupPermissions(groupId);
		return authorizeUserAndGroupsMapper.addPermissionsForGroups(groupId, roleIds);
	}
	
}
