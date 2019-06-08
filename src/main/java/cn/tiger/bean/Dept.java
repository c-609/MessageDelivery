package cn.tiger.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class Dept {
	private Integer id;
	private String name;
	@TableField("parentId")
	private Integer parentId;
	private Integer status;//-0-正常 1-逻辑删除
	@TableField("createTime")
	private Date createTime;
	@TableField("updateTime")
	private Date updateTime;
	@TableField("operatorId")
	private Integer operatorId;//操作人员id

}
