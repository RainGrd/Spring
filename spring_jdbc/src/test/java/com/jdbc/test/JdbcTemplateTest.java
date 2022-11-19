package com.jdbc.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.test
 * @Author: RainGrd
 * @CreateTime: 2022-06-06  20:35
 * @Description: TODO
 * @Version: 1.0
 */
public class JdbcTemplateTest {
    @Test
    public void test1(){
        /*加载spring全局配置文件*/
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int update = jdbcTemplate.update("insert into spring.tb_user  values(?,?,?,?,?,?)", null, "段荣贵", "123456", null, null, 3);
        System.out.println(update);
        /*创建数据源对象*/
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        /*获取数据连接池*/
//        jdbcTemplate.setDataSource(dataSource);
    }
    public void test2() {

    }
}
