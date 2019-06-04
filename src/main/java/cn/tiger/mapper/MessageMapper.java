package cn.tiger.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.tiger.bean.Message;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface MessageMapper extends BaseMapper<Message> {
	List<Message> findAllMessage();
	
	List<Message> findMessageByUserId(@Param("userId") Integer userId, @Param("stauts") Integer status);//--------------------
	//发消息
	Integer sendMessage(@Param("messageId")Integer messageId,@Param("recipientIds")Integer[] recipientIds);//------发消息
	
	Integer addMessage(Message message);
	
	Integer updateMessage(Message message);
	
	Integer deleteMessageById(@Param("id") Integer id);

	List<Message> findMessageByRecipientId(@Param("recipientId") Integer recipientId,@Param("status")Integer status);

	@Update("update messages set readNumber=readNumber+1 where id=#{id}")
	boolean addReadNumber(@Param("id") Integer id);
}
