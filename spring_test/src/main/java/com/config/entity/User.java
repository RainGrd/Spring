package com.config.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author RainGrd
 */
@Data
@ToString
public class User implements Serializable {
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
     * 当前用户具备的那些角色
     */
    private List<Role> roles;
}
