package cn.tiger.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tiger.bean.Message;
import cn.tiger.mapper.MessageMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageService {
	@Autowired
	MessageMapper messageMapper;
	
	public List<Message> getAllMessgage(){
		return messageMapper.findAllMessage();
	}
	
	public List<Message> getMessageByUserId(Integer userId){
		return messageMapper.findMessageByUserId(userId);
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

	@Transactional(rollbackFor = Exception.class)
	public Integer deleteMessageById(Integer id) {
		return messageMapper.deleteMessageById(id);
	}
}
