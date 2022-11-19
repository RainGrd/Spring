package com.bdqn.mapper;

import com.bdqn.entity.Account;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.mapper
 * @Author: RainGrd
 * @CreateTime: 2022-06-15  19:31
 * @Description: TODO
 * @Version: 1.0
 */
public interface AccountMapper {
    /**
     * 保存
     * @param account 账户对象
     */
    void save(Account account);

    /**
     * 查询数据
     * @return java.util.List
     */
    List<Account> accountFindAll();
}
