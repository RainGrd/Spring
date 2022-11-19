package com.config.service;

import com.config.Vo.PageBean;
import com.config.entity.Role;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.service
 * @Author: RainGrd
 * @CreateTime: 2022-06-07  11:32
 * @Description: TODO
 * @Version: 1.0
 */
public interface IRoleService {
    /**
     * 用于传输查询出来的角色数据
     * @param current 初始页
     * @param limit 查询的页数
     * @param role 角色类
     * @return com.bdqn.Vo.PageBean
     */
    PageBean<Role> roleAll(int current, int limit, Role role);

    /**
     * 用于查询出来符合条件的角色总数
     * @return java.lang.Long
     * @param role 角色类
     */
    Long roleCount(Role role);
    /**
     * 新增角色
     * @param role 新增角色
     */
    void save(Role role);


    public List<Role> roleList();
}
