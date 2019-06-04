package cn.tiger.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * create by yifeng
 */
@Data
public class MessageState {

    private Integer id;
    @TableField("messageId")
    private Integer messageId;
    @TableField("recipientId")
    private Integer recipientId;
    private Integer status;
    @TableField("readintTime")
    private LocalDateTime readintTime;
}
