package com.bdqn.pojo;

import java.io.Serializable;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.pojo
 * @Author: RainGrd
 * @CreateTime: 2022-05-27  09:17
 * @Description: TODO
 * @Version: 1.0
 */
public class User implements Serializable {
    private String name;
    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
