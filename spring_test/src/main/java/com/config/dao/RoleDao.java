package com.config.dao;

import com.config.entity.Role;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.dao
 * @Author: RainGrd
 * @CreateTime: 2022-06-07  11:36
 * @Description: TODO
 * @Version: 1.0
 */
public interface RoleDao {

    List<Role> queryRoleList();

    /**
     * 用于查询数据库中的符合条件的数据
     * @return java.util.List
     */
    <E> List<E> queryAll(Class<E> c, String sql, Object... args);

    /**
     * 用于查询数据库中符合条件的数据总数
     * @param sql sql语句
     */
    Long queryCount(String sql,Object ...args);
    void save(Role role);


}
