package cn.tiger.controller.msg;

import cn.tiger.bean.Message;
import cn.tiger.common.core.util.CommonConstants;
import cn.tiger.common.core.util.R;
import cn.tiger.security.util.SecurityUtils;
import cn.tiger.service.MessageService;
import cn.tiger.service.MessageStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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
        List<Message> messageList = messageService.getMessageByUserId(SecurityUtils.getUser().getId(), 0);
        // 去除已读的消息 filter中，判断为true则保留
        messageList.stream().filter(message -> (CommonConstants.MESSAGE_STATUS_READER) != message.getStatus());
        // TODO 需要把自己发的除外
        return new R(messageService.getMessageByUserId(SecurityUtils.getUser().getId(), 0));
    }

    public R getMessage() {
        LocalDateTime.now();
        return new R();
    }

    /**
     * 获取未读用户列表
     * @return
     */
    @GetMapping("/{mid}")
    public R getByUserList(@PathVariable Integer mid) {
        return new R(messageStatusService.findNotReadUserByMessageId(mid));
    }

    /**
     * 获取用户读取比例
     * @param mid
     * @return
     */
    @GetMapping("/proportion/{mid}")
    public R getReadProportion(@PathVariable Integer mid) {
        StringBuffer sb = new StringBuffer();
        int haveRead = messageStatusService.findReadUserByMessageId(mid).size();
        int unread = messageStatusService.findNotReadUserByMessageId(mid).size();
        sb.append(haveRead + "/" + (haveRead + unread));
        return new R(sb.toString());
    }

    /**
     * 编辑当前用户对应的消息状态
     * @param mid 消息id 0:未读 1：以读 -1：删除
     * @return
     */
    @PostMapping("/edit_state")
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
