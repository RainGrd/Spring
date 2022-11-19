package com.bdqn.web;

import com.bdqn.config.SpringConfiguration;
import com.bdqn.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.web
 * @Author: RainGrd
 * @CreateTime: 2022-05-27  14:37
 * @Description: TODO
 * @Version: 1.0
 */
public class UserController {
    public static void main(String[] args) {
       /* ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = app.getBean(UserService.class);
        userService.save();
        app.close();*/
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
