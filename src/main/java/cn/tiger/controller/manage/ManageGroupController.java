package cn.tiger.controller.manage;

import cn.tiger.common.core.util.R;
import cn.tiger.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by yifeng
 */
@RestController
@RequestMapping("/manage/group")
public class ManageGroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/list/user")
    public R getByUid(Integer uid) {
        return new R(groupService.getUserGroupsByUserId(uid));
    }
}
