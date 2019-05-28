package cn.tiger.security.sevice;

import cn.tiger.bean.User;
import cn.tiger.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * create by yifeng
 */
@Service
public class TigerUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findUserByUsername(username);
        // TODO 将来引入权限系统，需要将此user装换成UserInfo（目前尚未创建）

        return getUserDetails(user);
    }

    /**
     * 构建userdetails
     * @return 用户信息
     */
    private UserDetails getUserDetails(User user) {
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        List<Integer> deptIds = new ArrayList<>();
        user.getDepts().stream().forEach(dept -> {
            deptIds.add(dept.getId());
        });
        // TODO 此处应放入roleIds，参照pig,在SecurityUtils中取出
        Collection<? extends GrantedAuthority> authorities
                = AuthorityUtils.createAuthorityList("ROLE_ADMIN");


        // 构造security用户
        return new TigerUser(user.getId(), deptIds, user.getUsername(), user.getPassword(),
                true, true, true, true, authorities);
    }

}
