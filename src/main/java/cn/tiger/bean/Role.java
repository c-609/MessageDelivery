package cn.tiger.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@TableName("roles")
@EqualsAndHashCode (callSuper = true)
public class Role extends Model<Role> {
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private String name;
	private String alias;//别名 ROLE_name
    @TableField("createTime")
	private Date createTime;
    @TableField("updateTime")
	private Date updateTime;
    @TableField("operatorId")
	private Integer operatorId;
	private Integer status;

	
}
