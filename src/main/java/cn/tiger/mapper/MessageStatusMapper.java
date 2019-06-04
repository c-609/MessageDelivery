package cn.tiger.mapper;

import cn.tiger.bean.MessageState;
import cn.tiger.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface MessageStatusMapper extends BaseMapper<MessageState> {
    /**
     * 获取未读用户的ids
     * @param messageId
     * @return
     */
    List<User> findNotReadUserByMessageId(@Param("messageId")Integer messageId);

    List<User> findReadUserByMessageId(@Param("messageId")Integer messageId);

    Integer addMessageStatus(@Param("messageId")Integer messageId,@Param("userIds") Integer[] userIds);

    Integer updateMessageStatus(@Param("messageId")Integer messageId,@Param("userId")Integer userId,
                                @Param("status") Integer status, @Param("time") LocalDateTime time);

    Integer deleteMessageStatusbyMessageId(@Param("messageId")Integer messageId);

    Integer deleteMessageStatusByUserId(@Param("messageId")Integer messageId,@Param("userId")Integer userId);
}
