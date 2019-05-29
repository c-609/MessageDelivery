package cn.tiger.controller.msg;

import cn.tiger.bean.Message;
import cn.tiger.common.core.util.R;
import cn.tiger.security.util.SecurityUtils;
import cn.tiger.service.MessageService;
import cn.tiger.service.MessageStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * 消息管理 前端控制类
 * create by yifeng
 */
@RestController
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageStatusService messageStatusService;

    /**
     * 返回当前用户的消息列表
     *
     * @return
     */
    @GetMapping
    public R getUserMessage() {
        // TODO 需要把自己发的除外
        return new R(messageService.getMessageByUserId(SecurityUtils.getUser().getId()));
    }

    public R getMessage() {
        LocalDateTime.now();
        return new R();
    }

    /**
     * 当用户点击进消息的时候，可发送此请求
     * 通过id查询用户列表
     * @return
     */
    @GetMapping("/{id")
    public R getByUserList(@PathVariable Integer id) {

        return new R();
    }

    /**
     * 编辑当前用户对应的消息状态
     * @param mid 消息id 0:未读 1：以读 -1：删除
     * @return
     */
    @PutMapping("/edit_state")
    public R updateMessageState(Integer mid, Integer status) {
        return new R<>(messageStatusService.updateMessageStatus(mid, status));
    }

    /**
     * 删除消息 以及对于的用户关系
     * 暂时
     * @param mid
     * @return
     */
//    @DeleteMapping("/{mid}")
    public Integer deleteMessageById(Integer mid) {
        // 逻辑删除
        return messageService.deleteMessageById(mid);
    }

}
