package com.bdqn.dao.impl;

import com.bdqn.dao.UserDao;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.dao.impl
 * @Author: RainGrd
 * @CreateTime: 2022-05-27  14:31
 * @Description: TODO
 * @Version: 1.0
 * <bean id="userDao" class="com.bdqn.dao.impl.UserDaoImpl"></bean>
 */
@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save run...");
    }
}
