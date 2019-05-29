package cn.tiger.controller.msg.process;

import cn.tiger.bean.Message;
import cn.tiger.common.core.util.R;
import cn.tiger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接发消息控制类
 * create by yifeng
 */
@RestController
@RequestMapping("/msg/process")
public class ProcessController {

    @Autowired
    MessageService messageService;

    /**
     * 发送消息
     * @param message
     * @return
     */
    @RequestMapping("/send")
    public R send(Message message, Integer[] recipientIds) {
        return new R(messageService.sendMessage(message, recipientIds));
    }

}
