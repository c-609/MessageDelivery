package cn.tiger.service;

import cn.tiger.bean.DeptUser;
import cn.tiger.mapper.DeptUserMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by yifeng
 */
@Service
public class DeptUserService {

    @Autowired
    private DeptUserMapper deptUserMapper;

    /**
     * 根据条件查找部门用户
     * @param deptUser
     * @return
     */
    public List<DeptUser> getDeptUser(DeptUser deptUser) {
//        List<DeptUser> deptUserList = deptUser.sele(Wrappers.lambdaQuery(deptUser));
        List<DeptUser> deptUserList = deptUserMapper.selectList(Wrappers.lambdaQuery(deptUser));
//        deptUserMapper.
        return deptUserList;
    }

}
