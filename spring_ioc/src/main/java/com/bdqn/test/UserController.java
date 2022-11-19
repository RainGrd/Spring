package com.bdqn.test;

import com.bdqn.service.UserService;
import com.bdqn.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.test
 * @Author: RainGrd
 * @CreateTime: 2022-05-27  08:10
 * @Description: TODO
 * @Version: 1.0
 */
public class UserController {
    public static void main(String[] args) {
//        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app=new FileSystemXmlApplicationContext("D:\\materials\\Spring\\spring_ioc\\src\\main\\resources\\applicationContext.xml");


        UserService bean = app.getBean(UserService.class);
        bean.save();
        /*UserService userService=new UserServiceImpl();
        userService.save();*/
    }
}
