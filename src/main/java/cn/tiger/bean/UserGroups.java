package cn.tiger.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * create by yifeng
 */
@TableName("user_groups")
@Data
public class UserGroups extends Model<UserGroups> {
    @TableId
    private int id;
    private String name;
}
