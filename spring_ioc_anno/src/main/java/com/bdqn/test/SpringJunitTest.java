package com.bdqn.test;

import com.bdqn.config.SpringConfiguration;
import com.bdqn.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.test
 * @Author: RainGrd
 * @CreateTime: 2022-05-27  16:58
 * @Description: TODO
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
/*加载配置类*/
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {
    /**
     * Autowired：用于根据类型进行自动装配
     */
    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;

    @Test
    public void test1() throws SQLException {
        System.out.println(dataSource.getConnection());
        this.userService.save();
    }
}
