package com.bdqn.pojo;

import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.pojo
 * @Author: RainGrd
 * @CreateTime: 2022-05-31  20:43
 * @Description: TODO
 * @Version: 1.0
 */
public class User {
    private String username;
    private int age;

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
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
