package com.bdqn.test;

import com.bdqn.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.test
 * @Author: RainGrd
 * @CreateTime: 2022-05-26  19:04
 * @Description: TODO
 * @Version: 1.0
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        /*获取p文件*/
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(app);
        System.out.println(app.getId());
        UserDao bean = app.getBean(UserDao.class);
        System.out.println(bean);
        System.out.println(app.getApplicationName());
        System.out.println(app.getBean("userDao"));
        UserDao userDao =(UserDao) app.getBean("userDao");
        System.out.println(userDao);
        userDao.save();
    }
}
