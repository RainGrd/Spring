package com.bdqn.service.impl;

import com.bdqn.dao.AdminDao;
import com.bdqn.dao.impl.AdminDaoImpl;
import com.bdqn.entity.Admin;
import com.bdqn.service.AdminService;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.service
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  20:15
 * @Description: TODO
 * @Version: 1.0
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    List<Object> args = null;

    @Override
    public Admin login(String username, String password) {
        return adminDao.login(username, password);
    }

    @Override
    public void registered(Admin admin) {
        adminDao.registered(admin);
    }

    @Override
    public void forgotPwd(Admin admin) {
        args = new ArrayList<>();
        if (admin.getPassword() != null && !"".equals(admin.getPassword())) {
            args.add(admin.getPassword());
        }
        if (admin.getPhone() != null && !"".equals(admin.getPhone())) {
            args.add(admin.getPhone());
        }
        adminDao.forgotPwd(args.toArray());
    }
}
