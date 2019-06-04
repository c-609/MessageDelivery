package cn.tiger.service;

import cn.tiger.bean.MessageState;
import cn.tiger.bean.User;
import cn.tiger.common.core.util.CommonConstants;
import cn.tiger.mapper.MessageMapper;
import cn.tiger.mapper.MessageStatusMapper;
import cn.tiger.mapper.UserMapper;
import cn.tiger.security.util.SecurityUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageStatusService{

    @Autowired
    private MessageStatusMapper messageStatusMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 修改当前用户消息的状态，包括逻辑删除
     * @param messageId
     * @param status 0： 未读， 1：已读， -1：删除
     * @return
     */
    public Integer updateMessageStatus(Integer messageId, Integer status) {
        if (CommonConstants.USER_MESSAGE_STATUS_READER.equals(status)) {
            if (!whetherToRead(messageId)) {
                synchronized (status) {
                    messageMapper.addReadNumber(messageId);
                }
            }
        }
        return messageStatusMapper.updateMessageStatus(messageId, SecurityUtils.getUser().getId(), status, LocalDateTime.now());
    }

    public MessageState findMessageState(Integer mid, Integer status) {
        MessageState messageState = new MessageState();
        messageState.setMessageId(mid);
        messageState.setStatus(status);
        messageState.setRecipientId(SecurityUtils.getUser().getId());
        return messageStatusMapper.selectOne(Wrappers.lambdaQuery(messageState));
    }

    /**
     * 获取未读用户列表
     * @param mid
     * @return
     */
    public List<User> findNotReadUserByMessageId(Integer mid) {
        List<User> userList = messageStatusMapper.findNotReadUserByMessageId(mid);
        List<User> resultUserList = new ArrayList<>();
        userList.stream().forEach(user -> {
            resultUserList.add(userMapper.findUserByUserid(user.getId()));
        });
        return resultUserList;
    }

    /**
     * 查看已读消息
     * @param mid
     * @return
     */
    public List<User> findReadUserByMessageId(Integer mid) {
        return messageStatusMapper.findReadUserByMessageId(mid);
    }

    /**
     * 是否读取消息
     * @param mid
     * @return
     */
    public Boolean whetherToRead(Integer mid) {
        MessageState messageState = new MessageState();
        messageState.setMessageId(mid);
        messageState.setRecipientId(SecurityUtils.getUser().getId());
        MessageState ms = messageStatusMapper.selectOne(Wrappers.lambdaQuery(messageState));
        if (CommonConstants.USER_MESSAGE_STATUS_READER.equals(ms.getStatus())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


}
