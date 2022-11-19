package com.bdqn.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.entity
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  11:06
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@ToString
public class Dept {
    /**
     * 部门编号
     */
    private int deptId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 其他
     */
    private String remark;
}
