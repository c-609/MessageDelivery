package cn.tiger.mapper;

import cn.tiger.bean.Groups;
import cn.tiger.bean.UserGroups;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by yifeng
 */
@Mapper
public interface UserGroupsMapper extends BaseMapper<UserGroups> {

    List<Groups> getUserGroupsByUid(@Param("uid") Integer uid);

}
