package com.bdqn.dao.impl;

import com.bdqn.dao.UserDao;
import com.bdqn.pojo.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.dao.impl
 * @Author: RainGrd
 * @CreateTime: 2022-05-26  19:00
 * @Description: TODO
 * @Version: 1.0
 */
public class UserDaoimpl implements UserDao {

    private String username;
    private int age;
    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;


    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public void save() {
//        System.out.println(this.username+"="+this.age);
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("save run...");
    }
}
