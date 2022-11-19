package com.system.entity;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.entity
 * @Author: RainGrd
 * @CreateTime: 2022-06-16  19:29
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@ToString
public class User {
    /**
     * 用户主键
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
     * 邮件
     */
    private String email;
    /**
     * 手机号码
     */
    private String phoneNum;
    /**
     * 日期
     */
    private LocalDate birthDay;
    /**
     * 存放的角色集合
     */
    private List<Role> roles;
}
