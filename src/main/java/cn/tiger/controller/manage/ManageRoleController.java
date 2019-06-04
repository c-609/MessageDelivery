package cn.tiger.controller.manage;

import cn.tiger.common.core.util.R;
import cn.tiger.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
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
}
