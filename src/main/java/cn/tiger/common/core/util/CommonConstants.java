package cn.tiger.common.core.util;

/**
 * create by yifeng
 */
public interface CommonConstants {

        /**
         * 删除
         */
        String STATUS_DEL = "1";
        /**
         * 正常
         */
        String STATUS_NORMAL = "0";

        /**
         * 锁定
         */
        String STATUS_LOCK = "102";

        /**
         * 菜单
         */
        String MENU = "0";

        /**
         * 编码
         */
        String UTF8 = "UTF-8";

        /**
         * JSON 资源
         */
        String CONTENT_TYPE = "application/json; charset=utf-8";

        /**
         * 前端工程名
         */
        String FRONT_END_PROJECT = "tiger-eye";

        /**
         * 后端工程名
         */
        String BACK_END_PROJECT = "tiger";

        /**
         * 成功标记
         */
        Integer SUCCESS = 0;
        /**
         * 失败标记
         */
        Integer FAIL = 1;


        /**
         * 用户或密码错误
         */
        Integer USERNAME_OR_PASSWORD_NON = 3;

        /**
         * 未登录
         */
        public final int NO_LOGIN = -1;

        /**
         * 未知错误
         */
        Integer UNKNOWN_EXCEPTION = -99;
}
