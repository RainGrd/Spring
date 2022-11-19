package com.bdqn.service.impl;

import com.bdqn.dao.UserDao;
import com.bdqn.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.Service.impl
 * @Author: RainGrd
 * @CreateTime: 2022-05-27  14:33
 * @Description: TODO
 * @Version: 1.0
 */
//@Scope("prototype")
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        /*调用dao层的方法*/
        this.userDao.save();
    }

}
