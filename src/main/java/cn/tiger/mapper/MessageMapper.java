package cn.tiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.tiger.bean.Message;


@Mapper
public interface MessageMapper {
	List<Message> findAllMessage();
	
	List<Message> findMessageByUserId(@Param("userId") Integer userId, @Param("stauts") Integer status);//--------------------
	//发消息
	Integer sendMessage(@Param("messageId")Integer messageId,@Param("recipientIds")Integer[] recipientIds);//------发消息
	
	Integer addMessage(Message message);
	
	Integer updateMessage(Message message);
	
	Integer deleteMessageById(@Param("id") Integer id);
}
