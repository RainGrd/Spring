package com.bdqn.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

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
public class Person {
    /**
     * 员工主键
     */
    private int pid;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 薪水
     */
    private Double salary;
    /**
     * 所属部门
     */
    private Integer dept;
    /**
     * 所属部门
     */
    private List<Dept> deptList;
    /**
     * 其他
     */
    private String remark;
    /**
     *
     */
    private int delStatus;
}
