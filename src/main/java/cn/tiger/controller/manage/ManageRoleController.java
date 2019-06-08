package cn.tiger.controller.manage;

import cn.tiger.bean.DeptUser;
import cn.tiger.common.core.util.R;
import cn.tiger.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色
 * create by yifeng
 */
@RestController
@AllArgsConstructor
@RequestMapping("/manage/role")
public class ManageRoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取到角色列表
     * @param ids
     * @return
     */
    @GetMapping
    public R getListByRids(Integer[] ids) {
        return new R(roleService.listByRids(ids));
    }

    /**
     * 获取角色列表
     * 根据部门用户关系
     * @param deptUser 部门用户关系
     * @return
     */
    @GetMapping("/list/dept_user")
    public R listByDeptUser(DeptUser deptUser) {
        return new R(roleService.listByDeptUser(deptUser));
    }
}
