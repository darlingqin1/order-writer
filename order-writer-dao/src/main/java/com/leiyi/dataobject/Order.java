package com.leiyi.dataobject;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;


import java.time.LocalDateTime;

/**
 * 实体类：Order
 * 对应数据库表：order_0
 */
@Data
@TableName("`order`") // 对应数据库中的表名
public class Order {

    @TableId(value = "id", type = IdType.AUTO) // 指定主键字段和主键生成策略
    private Long id;

    private String orderId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String remark;
}
