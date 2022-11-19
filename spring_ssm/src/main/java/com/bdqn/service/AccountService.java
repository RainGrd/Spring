package com.bdqn.service;

import com.bdqn.entity.Account;
import com.bdqn.mapper.AccountMapper;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.service
 * @Author: RainGrd
 * @CreateTime: 2022-06-15  19:35
 * @Description: TODO
 * @Version: 1.0
 */
public interface AccountService {
    /**
     * 保存账户数据
     * @param account 账户实体
     */
    void save(Account account);

    /**
     * 查询账户数据
     * @return java.util.List
     */
    List<Account> accountFindAll();
}
