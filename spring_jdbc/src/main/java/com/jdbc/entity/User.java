package com.jdbc.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.entity
 * @Author: RainGrd
 * @CreateTime: 2022-06-07  08:54
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@ToString
public class User implements Serializable {
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户状态 0:超级管理员，1：普通管理员 2：普通用户
     */
    private Integer userStatus;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String phone;
}
