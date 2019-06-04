package cn.tiger.controller.manage;

import cn.tiger.common.core.util.CommonConstants;
import cn.tiger.common.core.util.R;
import cn.tiger.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by yifeng
 */
@RestController
@RequestMapping("/manage/user")
public class ManageUserController {
    @Autowired
    private DeptService deptService;

    /**
     * 根据部门id获取对应的用户
     * @param deptId 部门id
     * @param deptType 部门类型 1：学生 2：老师
     * @return
     */
    @GetMapping("/dept")
    public R listByDeptId(Integer deptId, Integer deptType) {
        //TODO 此处写法需要优化， 将来用户类型将会变多
        if (CommonConstants.DEPT_TYPE_STUDENT.equals(deptType)) {
            return new R(deptService.getStudentByDeptid(deptId));
        }else {
            return new R(deptService.getTeacherByDeptid(deptId));
        }
    }
}
