package cn.tiger.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
	private Integer id;

	private Integer senderId;
	private String senderName;
	private Date time;
	private Integer status;
	private String content;
	private Integer number;
	private Integer readNumber;
	private Integer roleId;
	private Integer deptId;
	private  Role role;
	private Dept dept;

}
