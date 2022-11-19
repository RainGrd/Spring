package com.config.service;

import com.config.Vo.PageBean;
import com.config.entity.User;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.service
 * @Author: RainGrd
 * @CreateTime: 2022-06-09  08:12
 * @Description: TODO
 * @Version: 1.0
 */
public interface IUserService {

    PageBean<User> pageInfo(int current, int pageSize, User user);


    public void save(User user,Long[] roleIds);

    void deleteUserById(Long userId);

    User login(String username, String password);
}
