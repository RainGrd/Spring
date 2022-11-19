package com.bdqn.service.impl;

import com.bdqn.dao.UserDao;
import com.bdqn.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.service.impl
 * @Author: RainGrd
 * @CreateTime: 2022-05-27  08:05
 * @Description: TODO
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    @Override
    public void save() {
        this.userDao.save();
    }
}
