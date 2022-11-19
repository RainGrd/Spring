package com.system.service.impl;

import com.system.entity.Role;
import com.system.mapper.RoleMapper;
import com.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.service.impl
 * @Author: RainGrd
 * @CreateTime: 2022-06-17  08:18
 * @Description: TODO
 * @Version: 1.0
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;



}
