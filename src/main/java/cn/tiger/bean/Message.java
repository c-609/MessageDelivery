package cn.tiger.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("messages")
public class Message extends Model<Message> implements Serializable {

	private static final long serialVersionUID = 1L;
	@TableId
	private int id;
	@TableField("senderId")
	private Integer senderId;
	@TableField("senderName")
	private String senderName;
	private LocalDateTime time;
	private Integer status;
	private String content;
	private Integer number;
	@TableField("readNumber")
	private Integer readNumber;
	@TableField("roleId")
	private Integer roleId;
	@TableField("deptId")
	private Integer deptId;
	private String title;
	@TableField(exist = false)
	private  Role role;
	@TableField(exist = false)
	private Dept dept;

	@Override
	protected Serializable pkVal() {
		return this.getId();
	}
}
