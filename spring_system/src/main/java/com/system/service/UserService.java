package com.system.service;

import com.github.pagehelper.PageInfo;
import com.system.entity.User;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.service
 * @Author: RainGrd
 * @CreateTime: 2022-06-16  20:02
 * @Description: TODO
 * @Version: 1.0
 */
public interface UserService {
    /**
     * 查询方法
     *
     * @param user 用户类对象
     * @return com.github.pagehelper.PageInfo
     */
    PageInfo<User> findUserAll(int current, int pageSize, User user);

   /**
    * 用户登录方法
    * @param username 用户名
    * @param password 密码
    * @return com.system.entity.User
    */
    User login(String username, String password);
}
