package cn.tiger.service;

import cn.tiger.bean.User;
import cn.tiger.mapper.MessageStatusMapper;
import cn.tiger.security.util.SecurityUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageStatusService {

    @Autowired
    private MessageStatusMapper messageStatusMapper;

    /**
     * 修改当前用户消息的状态，包括逻辑删除
     * @param messageId
     * @param status 0： 未读， 1：已读， -1：删除
     * @return
     */
    public Integer updateMessageStatus(Integer messageId, Integer status) {
        return messageStatusMapper.updateMessageStatus(messageId, SecurityUtils.getUser().getId(), status, LocalDateTime.now());
    }
}
