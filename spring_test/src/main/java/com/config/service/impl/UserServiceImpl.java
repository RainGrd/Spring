package com.config.service.impl;

import com.config.Vo.PageBean;
import com.config.dao.UserDao;
import com.config.entity.Role;
import com.config.entity.User;
import com.config.service.IUserService;
import com.config.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.service.impl
 * @Author: RainGrd
 * @CreateTime: 2022-06-09  08:33
 * @Description: TODO
 * @Version: 1.0
 */
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public PageBean<User> pageInfo(int current, int pageSize, User user) {
        /*sql语句*/
        StringBuilder sql = new StringBuilder();
        sql.append("select * from t_user where del_status=0");
        /*存放参数的集合*/
        List<Object> list = new ArrayList<>();
        if (user != null) {
            if (user.getUsername() != null && !"".equals(user.getUsername())) {
                sql.append(" and userName like concat('%',?,'%')");
                list.add(user.getUsername());
            }
            if (user.getPhoneNum() != null && !"".equals(user.getPhoneNum())) {
                sql.append(" and phoneNum like concat('%',?,'%')");
                list.add(user.getPhoneNum());
            }
        }
        list.add(current);
        list.add(pageSize);
        sql.append(" limit ?,?");
        /*处理条件*/
        PageBean<User> userPageBean = Util.pageList(sql.toString(), User.class, list.toArray());
        for (User data : userPageBean.getData()) {
            data.setRoles(userDao.queryObject(data.getId(), Role.class));
        }
        return userPageBean;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        /*1.向t_user表存储数据*/
        Long userId = userDao.save(user);
        /*2.向t_user_role表存储多条数据*/
        userDao.saveUserRoleRel(userId,roleIds);
    }

    @Override
    public void deleteUserById(Long userId) {
        userDao.deleteUserById(userId);
    }

    @Override
    public User login(String username, String password) {
        try {
            return  userDao.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
