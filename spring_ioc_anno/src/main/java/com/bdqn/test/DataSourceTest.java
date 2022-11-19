package com.bdqn.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.test
 * @Author: RainGrd
 * @CreateTime: 2022-05-27  10:47
 * @Description: TODO
 * @Version: 1.0
 */
public class DataSourceTest {
    @Test
    /**
     * @description: 测试手动创建C3p0数据源
     * @author: RainGrd
     * @date: 2022/5/27 10:50:58  
     **/
    public void test1() throws Exception {
        /*创建数据源*/
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("drg1224605");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    /**
     * @description: 测试手动创建druid数据源
     * @author: RainGrd
     * @date: 2022/5/27 11:04:00
     **/
    public void test2() throws Exception {
        /*创建数据源*/

        DruidDataSource dataSource = new DruidDataSource();
        System.out.println(dataSource);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("drg1224605");
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    /**
     * @description: 加载配置文件
     * @author: RainGrd
     * @date: 2022/5/27 11:04:00
     **/
    public void test3() throws Exception {
        /*创建数据源*/
        ResourceBundle resource = ResourceBundle.getBundle("jdbc");
        System.out.println(resource);
        String driver=resource.getString("jdbc.driver");
        String url=resource.getString("jdbc.url");
        String username=resource.getString("jdbc.username");
        String password=resource.getString("jdbc.password");
        /*创建数据源对象，设置连接参数*/
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    /**
     * @description: 加载配置文件
     * @author: RainGrd
     * @date: 2022/5/27 11:04:00
     **/
    public void test4() throws Exception {
        /*创建数据源*/
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = app.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
