package com.bdqn.dao;

import com.bdqn.entity.Admin;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.dao
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  20:10
 * @Description: TODO
 * @Version: 1.0
 */
public interface AdminDao {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Admin login(String username,String password);

    /**
     * 注册方法
     * @param admin
     */
    void registered(Admin admin);
    /**
     * 忘记密码
     */
    void forgotPwd(Object[] objs);
}
