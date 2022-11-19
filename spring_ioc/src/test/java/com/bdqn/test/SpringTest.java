package com.bdqn.test;

import com.bdqn.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.test
 * @Author: RainGrd
 * @CreateTime: 2022-05-26  19:17
 * @Description: TODO
 * @Version: 1.0
 */
public class SpringTest {
    @Test
    /**
     * @description: 测试Scope属性
     * @author: RainGrd
     * @date: 2022/5/26 19:21:50
     **/
    public void test1(){
        /*获取配置文件*/
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*
        * singleton:
        * prototype
        * */
        UserDao bean1= app.getBean(UserDao.class);
        System.out.println(bean1);
        /*手动关闭*/
        ((ClassPathXmlApplicationContext) app).close();

    }
    @Test
    public void test2(){
        /*获取配置文件*/
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*
         * singleton:
         * prototype
         * */
        UserDao bean1= app.getBean(UserDao.class);
        System.out.println(bean1);
        /*手动关闭*/
        ((ClassPathXmlApplicationContext) app).close();

    }
}
