package com.bdqn.factory;

import com.bdqn.dao.UserDao;
import com.bdqn.dao.impl.UserDaoimpl;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.factory
 * @Author: RainGrd
 * @CreateTime: 2022-05-26  20:38
 * @Description: TODO
 * @Version: 1.0
 */
public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoimpl();
    }
}
