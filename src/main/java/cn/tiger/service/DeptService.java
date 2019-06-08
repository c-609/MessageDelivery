package cn.tiger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cn.tiger.dto.DeptTree;
import cn.tiger.vo.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tiger.bean.Dept;
import cn.tiger.bean.Student;
import cn.tiger.bean.Teacher;
import cn.tiger.bean.User;
import cn.tiger.mapper.DeptMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptService {
	@Autowired
	DeptMapper deptMapper;
	
	public List<Dept> getDeptList(){
		return deptMapper.findDeptList();
	}

	public List<Dept> getListByIds(Integer[] ids) {
		List<Dept> deptList = new ArrayList<>();
		for (Integer id : ids) {
			deptList.add(deptMapper.selectById(id));
		}
		return deptList;
	}

	public Integer addDept(Dept  dept) {
		return deptMapper.addDept(dept);
	}
	
	public Integer updateDept(Dept dept) {
		return deptMapper.updateDept(dept);
	}
	
	public Integer deleteDeptById(Integer dId) {
		return deptMapper.deleteDeptById(dId);
	}
	
	public Integer addDeptForUsers(Integer userId,Integer[] deptIds) {
		return deptMapper.addDeptForUsers(userId, deptIds);
	}

	@Transactional(rollbackFor = Exception.class)
	public Integer updateDeptForUsers(Integer userId,Integer[] deptIds) {
		deptMapper.deleteDeptUsersByUserid(userId);
		return deptMapper.addDeptForUsers(userId, deptIds);
	}
	
	public List<Student> getStudentByDeptid(Integer deptId){
		return deptMapper.findStudentByDeptid(deptId);
	}
	
	public List<Teacher> getTeacherByDeptid(Integer deptId){
		return deptMapper.findTeacherByDeptid(deptId);
	}

	/**
	 * 查询部门树
	 * @return
	 */
	public List<DeptTree> listDeptTree() {
		return getDeptTree(deptMapper.findDeptList());
	}

	/**
	 * 构建部门树
	 *
	 * @param depts
	 * @return
	 */
	private List<DeptTree> getDeptTree(List<Dept> depts) {
		List<DeptTree> treeList = depts.stream()
				.filter(dept -> !dept.getId().equals(dept.getParentId()))
				.map(dept -> {
					DeptTree node = new DeptTree();
					node.setId(dept.getId());
					node.setParentId(dept.getParentId());
					node.setName(dept.getName());
					return node;
				}).collect(Collectors.toList());
		return TreeUtil.buildByLoop(treeList, -1);
	}
}
