package cn.tiger.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tiger.bean.Message;
import cn.tiger.mapper.MessageMapper;

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
	
//	public Integer sendMessage(Message message,Integer[] recipientIds) {
//		messageMapper.addMessage(message);
//		
//	}
	
	public Integer addMessage(Message message) {
		return messageMapper.addMessage(message);
	}
	
	public Integer updateMessage(Message message) {
		return messageMapper.updateMessage(message);
	}
	
	public Integer deleteMessageById(Integer id) {
		return messageMapper.deleteMessageById(id);
	}
}
