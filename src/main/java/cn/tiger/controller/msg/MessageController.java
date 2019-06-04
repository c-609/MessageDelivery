package cn.tiger.controller.msg;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Editor;
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
import java.util.Arrays;
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
     * @Param status 0：未读 1：已读
     * @Param presenceIds 已存在的消息列表
     * @return
     */
    @GetMapping
    public R getUserMessage(Integer status, Integer[] presenceIds) {
        List<Message> messageList = messageService.findMessageByRecipientId(status);
        List presenceList = CollUtil.newArrayList(presenceIds);
        if (!CollUtil.isNotEmpty(presenceList)) {
            return new R(messageList);
        }
        List DeduplicationList = CollUtil.filter(messageList, new Editor<Message>() {
            @Override
            public Message edit(Message message) {
                for (Integer id : presenceIds) {
                    if (message.getId().equals(id)) {
                        return null;
                    }
                }
                return message;
            }
        });
        // TODO 需要把自己发的除外
        return new R(DeduplicationList);
    }

    @GetMapping("/send_list")
    public R getSendMessage(Integer status) {
        return new R(messageService.getMessageByUserId(status));
    }

    @GetMapping("/item/{mid}")
    public R getById(@PathVariable Integer mid) {
        return new R(messageService.getById(mid));
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
     * 编辑当前用户对应的消息状态
     * @param mid 消息id
     * @param mid 消息状态 0:未读 1：已读 -1：删除
     * @return
     */
    @PostMapping("/edit_state")
    public R updateMessageState(Integer mid, Integer status) {
        return new R<>(messageStatusService.updateMessageStatus(mid, status));
    }

    /**
     * 获取用户消息状态
     * @param mid 消息id
     * @return
     */
    @GetMapping("/user_message_status")
    public R messageState(Integer mid, Integer status) {
        return new R(messageStatusService.findMessageState(mid, status));
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
