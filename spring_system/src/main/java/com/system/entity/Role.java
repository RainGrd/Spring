package com.system.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.entity
 * @Author: RainGrd
 * @CreateTime: 2022-06-16  19:29
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@ToString
public class Role {
    /**
     * 角色主键
     */
    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDesc;

}
