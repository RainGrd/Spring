package com.system.mapper;

import com.system.entity.Role;
import com.system.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.mapper
 * @Author: RainGrd
 * @CreateTime: 2022-06-16  19:31
 * @Description: TODO
 * @Version: 1.0
 */
public interface UserMapper {
    /**
     * 根据条件查询用户对象
     * @return java.util.List
     */

    /**
     * 根据条件查询用户对象
     * @param user 用户对象
     * @return java.util.List
     */
    List<User> findAllByUser(User user);

    /**
     * 查询分页条数
     * @param user 用户类对象
     * @return java.lang.Long
     */
    int findCountByUser(User user);
    /**
     * 返回查询到角色实体对象
     * @param userId 角色主键
     * @return java.util.List
     */
    List<Role> findRoleList(Long userId);

    /**
     * 登录方法
     * @param username 用户名
     * @param password 密码
     * @return com.system.entity.User
     */

    User login(@Param("username") String username,@Param("password") String password);
}
