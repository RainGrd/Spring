package com.jdbc.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.entity
 * @Author: RainGrd
 * @CreateTime: 2022-06-06  20:23
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@ToString
public class Brand implements Serializable {
    /**
     *  id 主键
     */
    private Integer id;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 排序字段
     */
    private Integer ordered;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 状态：0：禁用  1：启用
     */
    private Integer status;
}
