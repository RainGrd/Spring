package com.jdbc.test;

import com.jdbc.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.test
 * @Author: RainGrd
 * @CreateTime: 2022-06-07  08:20
 * @Description: TODO
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {
    /**
     * Autowired把jdbcTemplate自动生成get,set方法,并自动寻找被标注的方法的入参类型的Bean
     *省略了以下内容
     * ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
     * JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate(){
        int update = jdbcTemplate.update("update spring.tb_user set  username=?  where id=?;", "小段", 4);
        System.out.println(update);
    }
    public void testDelete(){

    }
    @Test
    public void testQueryAll(){
        List<User> query = jdbcTemplate.query("select * from spring.tb_user",new BeanPropertyRowMapper<User>(User.class));
        System.out.println(query);
    }

    @Test
    public void testQuery(){
        User user = jdbcTemplate.queryForObject("select * from tb_user where id=?;", new BeanPropertyRowMapper<User>(User.class), 4);
        System.out.println(user);
    }


    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from tb_user", Long.class);
        System.out.println(count);
    }
}
