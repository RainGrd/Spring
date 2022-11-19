package com.bdqn.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.entity
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  20:07
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@ToString
public class Admin implements Serializable {
    /**
     * 用户id
     */
    private int aid;
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号码
     */
    private String phone;
}
