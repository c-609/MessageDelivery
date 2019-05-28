package cn.tiger.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import cn.tiger.RightsManageApplicationTest;
import cn.tiger.bean.Message;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
//@Rollback
public class MessageServiceTest extends RightsManageApplicationTest{
	@Autowired
	MessageService messageService;
	@Test
	public void testGetAllMessage() {
		List list = messageService.getAllMessgage();
		System.out.println(list);
	}
	
	@Test
	public void testGetMessageByUserid() {
		List list = messageService.getMessageByUserId(1);
		System.out.println(list);
	}
	
	@Test
	public void testAddMessage() {
		Message message = new Message();
		message.setSenderId(2);
		message.setContent("test棒");
		Integer i = messageService.addMessage(message);
		System.out.println(i);
	}
	@Test
	public void testUpdateMessage() {
		Message message = new Message();
		message.setId(2);
		message.setContent("test棒bangbang");
		message.setStatus(1);
		Integer i = messageService.updateMessage(message);
		System.out.println(i);
	}
	@Test
	public void testDeleteMessage() {
		Integer i = messageService.deleteMessageById(2);
		System.out.println(i);
	}

	@Test
	public void testSendMessage() {
		Message message = new Message();
		message.setSenderId(2);
		message.setContent("test棒");
		Integer[] recipientIds = {7, 8, 9};
		Integer i = messageService.sendMessage(message, recipientIds);
		System.out.println(i);
	}

}
