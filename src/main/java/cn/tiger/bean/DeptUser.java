package cn.tiger.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户部门
 * create by yifeng
 */
@Data
@TableName("dept_user")
public class DeptUser extends Model<DeptUser> {
    @TableId
    private Integer id;
    /**
     *  部门id
     */
    @TableField("deptId")
    private Integer deptId;
    /**
     * 用户id
     */
    @TableField("userId")
    private Integer userId;
    /**
     * 角色id
     */
    @TableField("roleId")
    private Integer roleId;

    //重写这个方法，return当前类的主键
    @Override
    protected Serializable pkVal() {
        return id;
    }
}
