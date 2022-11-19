package com.config.service.impl;

import com.config.Vo.PageBean;
import com.config.dao.RoleDao;
import com.config.entity.Role;
import com.config.service.IRoleService;
import com.config.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.service.impl
 * @Author: RainGrd
 * @CreateTime: 2022-06-07  11:32
 * @Description: TODO
 * @Version: 1.0
 */
public class RoleServiceImpl implements IRoleService {
    /**
     * 生成Dao层对象
     */
    @Autowired
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public PageBean<Role> roleAll(int current, int limit, Role role) {
        /*用于存放参数*/
        List<Object> list=new ArrayList<>();
        /*查询sql*/
        StringBuilder sql = new StringBuilder();
        sql.append("select * from t_role ");
        /*处理条件*/
        if (role.getRoleName() != null && !"".equals(role.getRoleName())) {
            sql.append(" where roleName like concat('%',?,'%') ");
            list.add(role.getRoleName());
        }
        if (role.getRoleDesc() != null && !"".equals(role.getRoleDesc())) {
            sql.append(" and roleDesc like concat('%',?,'%')");
            list.add(role.getRoleDesc());
        }
        list.add(current);
        list.add(limit);
        sql.append(" limit ?,?");
        /*查询被分页后的数据*/
        return Util.pageList(sql.toString(),Role.class,list.toArray());
    }

    @Override
    public Long roleCount(Role role) {
        return null;
    }

    /**
     * 添加角色
     * @param role 新增角色
     */
    @Override
    public void save(Role role) {
        if(role!=null){
            roleDao.save(role);
        }
    }

    @Override
    public List<Role> roleList() {
        return roleDao.queryRoleList();
    }
}
