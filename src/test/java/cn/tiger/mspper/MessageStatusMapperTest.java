package cn.tiger.mspper;

import cn.tiger.RightsManageApplicationTest;
import cn.tiger.mapper.MessageStatusMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class MessageStatusMapperTest extends RightsManageApplicationTest {

    @Autowired
    MessageStatusMapper messageStatusMapper;
    @Test
    public void testFindNotReadUserByMessageId(){
        List list = messageStatusMapper.findNotReadUserByMessageId(8);
        System.out.println(list);
    }
    @Test
    public void findReadUserByMessageId(){
        List list = messageStatusMapper.findReadUserByMessageId(8);
        System.out.println(list);
    }
    @Test
    public void addMessageStatus(){
        Integer[] is = new Integer[]{2,3,4};
        Integer i = messageStatusMapper.addMessageStatus(8,is);
       // List list = messageStatusMapper.findNotReadUserByMessageId(8);
        System.out.println(i);
    }

    @Test
    public void updateMessageStatus(){
        Integer i = messageStatusMapper.updateMessageStatus(8,2, LocalDateTime.now());
        System.out.println(i);
    }
    @Test
    public void deleteMessageStatusByUserId(){
        Integer i = messageStatusMapper.deleteMessageStatusByUserId(8,1);
        System.out.println(i);
    }

    @Test
    public void deleteMessageStatusbyMessageId(){
        Integer i = messageStatusMapper.deleteMessageStatusbyMessageId(8);
        System.out.println(i);
    }
}
