package cn.tiger.mspper;

import cn.tiger.RightsManageApplicationTest;
import cn.tiger.mapper.MessageMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * create by yifeng
 */
public class MessageMapperTest extends RightsManageApplicationTest {

    @Autowired
    MessageMapper messageMapper;

    @Test
    public void testGetMessageByUserId() {
        System.out.println(messageMapper.findMessageByUserId(3, 0));
    }
}
