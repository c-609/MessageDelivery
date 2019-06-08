package cn.tiger.service;

import cn.tiger.bean.Groups;
import cn.tiger.mapper.UserGroupsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by yifeng
 */
@Service
public class GroupService {
    @Autowired
    private UserGroupsMapper userGroupsMapper;

    public List<Groups> getUserGroupsByUserId(Integer uid) {
        return userGroupsMapper.getUserGroupsByUid(uid);
    }
}
