package cn.tiger.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cn.tiger.bean.Student;
import cn.tiger.bean.Teacher;
import cn.tiger.common.core.util.CommonConstants;
import cn.tiger.mapper.MessageStatusMapper;
import cn.tiger.security.util.SecurityUtils;
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
	@Autowired
	private DeptService deptService;
	
	public List<Message> getAllMessgage(){
		return messageMapper.findAllMessage();
	}

	public Message getById(Integer mid) {
		return messageMapper.selectById(mid);
	}

	public List<Message> getMessageByUserId(Integer status){
		return messageMapper.findMessageByUserId(SecurityUtils.getUser().getId(), status);
	}

	/**
	 * 获取消息列表 根据接受者id
	 * @param status 需要查询的消息状态
	 * @return
	 */
	public List<Message> findMessageByRecipientId(Integer status) {
		return messageMapper.findMessageByRecipientId(SecurityUtils.getUser().getId(), status);
	}

	/**
	 * 发送消息 群发老师和学生
	 * @param message 消息内容
	 * @param deptIds 部门id列表
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public Integer sendMessage(Message message, Integer[] deptIds) {

		Set<Integer> set = new HashSet<>();
		Arrays.stream(deptIds).forEach(id -> {
			// 查询学生
			List<Student> stuList = deptService.getStudentByDeptid(id);
			stuList.stream().forEach(student -> set.add(student.getUserId()));
			// 查询教师
			List<Teacher> teaList = deptService.getTeacherByDeptid(id);
			teaList.stream().forEach(teacher -> set.add(teacher.getUserId()));
		});
		message.setNumber(set.size());
		// 过滤发送者
		Set<Integer> newSet = set.stream().filter(id -> !id.equals(SecurityUtils.getUser().getId())).collect(Collectors.toSet());
		// 消息体
		messageMapper.addMessage(message);
		// 用户消息关联
		return messageMapper.sendMessage(message.getId(),  set.toArray(new Integer[newSet.size()]));
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
