package cn.tiger.controller.manage;

import cn.tiger.common.core.util.R;
import cn.tiger.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by yifeng
 */
@RestController
@RequestMapping("/manage/dept")
public class ManageDeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 获取部门树
     * @return 部门树
     */
    @GetMapping("/tree")
    public R listDeptTrees() {
        return new R(deptService.listDeptTree());
    }

}
