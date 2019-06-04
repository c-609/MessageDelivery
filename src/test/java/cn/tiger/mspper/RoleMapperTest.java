package cn.tiger.mspper;

import cn.tiger.RightsManageApplicationTest;
import cn.tiger.bean.Role;
import cn.tiger.mapper.RoleMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * create by yifeng
 */
public class RoleMapperTest extends RightsManageApplicationTest {

    @Autowired
    RoleMapper roleMapper;

    @Test
    public void testListByRids() {
        Role role = new Role();
//        role.selectOne(1);
        System.out.println(roleMapper.selectById(1));
    }
}
