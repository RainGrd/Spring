package com.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.entity.User;
import com.system.mapper.UserMapper;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.service.impl
 * @Author: RainGrd
 * @CreateTime: 2022-06-16  20:03
 * @Description: TODO
 * @Version: 1.0
 */
@Service("userService")
@Transactional(transactionManager = "dataSourceTransactionManager")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findUserAll(int current, int pageSize, User user) {
        /*开启分页功能*/
        PageHelper.startPage(current, pageSize);
        List<User> allByUser = userMapper.findAllByUser(user);

        /*用于将查询出来的数据为null全部替换为“”*/
        for (User userAll : allByUser) {
            if (userAll.getEmail() == null) {
                userAll.setEmail("");
            }
            if (userAll.getPhoneNum() == null) {
                userAll.setPhoneNum("");
            }
            userAll.setRoles(userMapper.findRoleList(userAll.getId()));
        }
        int countByUser = userMapper.findCountByUser(user);
        PageInfo<User> userPageInfo = new PageInfo<>(allByUser,
                countByUser);
        System.out.println(userPageInfo);
        return userPageInfo;
    }

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }
}
