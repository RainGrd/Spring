package com.config.dao;

import com.config.entity.User;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.dao
 * @Author: RainGrd
 * @CreateTime: 2022-06-09  08:55
 * @Description: TODO
 * @Version: 1.0
 */
public interface UserDao {
    /**
     *
     * @param sql 要执行的SQL
     * @param params 参数列表
     * @return java.util.List
     */
    List<User> queryUserAll(String sql, Object ... params);

    /**
     *
     * @param sql 要执行的sql语句
     * @param params 执行条件
     * @return java.lang.Long
     */
    Long queryCount(String sql,Object [] params);


    <E> List<E> queryObject(Long id,Class<E> eClass);


    Long save(User user);


    void saveUserRoleRel(Long id, Long[] roleIds);


    void deleteUserById(Long userId);

    User login(String username, String password);
}
