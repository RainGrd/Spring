package com.bdqn.service.impl;

import com.bdqn.dao.UserDao;
import com.bdqn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
@Component("userService")
//@Scope("prototype")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    /*为driver赋值*/
    @Value("${jdbc.driver}")
    private String driver;
    /*默认数据类型进行匹配的*/
//    @Autowired
    /*是根据Id值在容器中进行匹配的 但是此处的Qualifier是根据Autowired配合开发使用*/
//    @Qualifier("userDao")
    @Resource(name="userDao")   //相当于Autowired+Qualifier
    private UserDao userDao;


    @Override
    public void save() {
        System.out.println(this.driver);
        /*调用dao层的方法*/
        this.userDao.save();
    }
    @PostConstruct
    public void init(){
        System.out.println("service对象的初始化方法");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("service对象的销毁方法");
    }
}
