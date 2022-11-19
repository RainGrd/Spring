package com.bdqn.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.entity
 * @Author: RainGrd
 * @CreateTime: 2022-06-15  19:17
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@ToString
public class Account {
    /**
     * 管理员ID
     */
    private Long id;
    /**
     * 管理员名称
     */
    private String accountName;
    /**
     * 金额
     */
    private Double accountMoney;

}
