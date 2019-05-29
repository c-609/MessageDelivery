package cn.tiger.service;

import java.util.List;

import cn.tiger.mapper.MessageStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tiger.bean.Message;
import cn.tiger.mapper.MessageMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageService {
	@Autowired
	private MessageMapper messageMapper;
	@Autowired
    private MessageStatusMapper messageStatusMapper;
	
	public List<Message> getAllMessgage(){
		return messageMapper.findAllMessage();
	}
	
	public List<Message> getMessageByUserId(Integer userId, Integer status){
		return messageMapper.findMessageByUserId(userId, status);
	}

	/**
	 * 发送消息
	 * @param message 消息内容
	 * @param recipientIds 接受者id
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public Integer sendMessage(Message message,Integer[] recipientIds) {
		// 消息体
		messageMapper.addMessage(message);
		// 用户消息关联
		return messageMapper.sendMessage(message.getId(), recipientIds);
	}

	@Transactional(rollbackFor = Exception.class)
	public Integer addMessage(Message message) {
		return messageMapper.addMessage(message);
	}

	@Transactional(rollbackFor = Exception.class)
	public Integer updateMessage(Message message) {
		return messageMapper.updateMessage(message);
	}

    /**
     * 删除消息以及所对应的所有的用户关系
     * @param mid
     * @return
     */
	@Transactional(rollbackFor = Exception.class)
	public Integer deleteMessageById(Integer mid) {
	    // 删除用户消息关系
        messageStatusMapper.deleteMessageStatusbyMessageId(mid);
		return messageMapper.deleteMessageById(mid);
	}

}
