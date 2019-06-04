package cn.tiger.mapper;

import cn.tiger.bean.Role;
import cn.tiger.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
	List<Role> findAllRole();
	
	Integer addRole(Role role);
	
	Integer updateRole(Role role);
	
	Integer deleteRoleById(@Param("rId") Integer rId);
	
	List<User> findUserByRoleId(@Param("rId") Integer rId);
}
