package com.bdqn.service;

import com.bdqn.entity.Admin;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.service
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  20:15
 * @Description: TODO
 * @Version: 1.0
 */
public interface AdminService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Admin login(String username,String password);

    /**
     * 注册
     * @param admin
     */
    void registered(Admin admin);

    /**
     * 修改密码
     * @param admin
     */
    void forgotPwd(Admin admin);
}
