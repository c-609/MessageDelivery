package cn.tiger.controller;

import cn.tiger.common.core.util.CommonConstants;
import cn.tiger.common.core.util.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by yifeng
 */
@RestController
public class RegLoginController {
    @RequestMapping("/login_p")
    public R login() {
        R resultBean = new R();
        resultBean.setCode(CommonConstants.NO_LOGIN);
        return resultBean;
    }
}
