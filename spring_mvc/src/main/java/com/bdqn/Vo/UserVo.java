package com.bdqn.Vo;

import com.bdqn.pojo.User;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.Vo
 * @Author: RainGrd
 * @CreateTime: 2022-06-01  16:53
 * @Description: TODO
 * @Version: 1.0
 */
public class UserVo {

    private List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "data=" + data +
                '}';
    }
}
