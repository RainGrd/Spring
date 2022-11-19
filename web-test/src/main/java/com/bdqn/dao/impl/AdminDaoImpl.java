package com.bdqn.dao.impl;

import com.bdqn.dao.AdminDao;
import com.bdqn.entity.Admin;
import com.bdqn.utils.DBUtil;

import java.util.ArrayList;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.dao
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  20:10
 * @Description: TODO
 * @Version: 1.0
 */
public class AdminDaoImpl implements AdminDao {



    @Override
    public Admin login(String username, String password) {
        return DBUtil.queryOne(Admin.class, "select * from t_admin where username=? and password=?", username,
                password);
    }

    @Override
    public void registered(Admin admin) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(admin.getName());
        objects.add(admin.getUsername());
        objects.add(admin.getPassword());
        objects.add(admin.getPhone());
        DBUtil.update("insert t_admin values(null,?,?,?,?)",objects.toArray());
    }

    @Override
    public void forgotPwd(Object[] objs) {
        DBUtil.update("update t_admin set password=? where phone=?",objs);
    }
}
