package com.liboshuai.starlink.demo.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class UserEntity {
    @TableId
    private Long id;
    @TableField
    private String username;
    @TableField
    private String password;
}
