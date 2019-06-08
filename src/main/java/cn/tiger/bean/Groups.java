package cn.tiger.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("groups")
@EqualsAndHashCode(callSuper = true)
public class Groups extends Model<Groups> {
	private Integer id;
	private String name;
}
