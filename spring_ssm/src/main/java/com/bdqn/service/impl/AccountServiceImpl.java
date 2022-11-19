package com.bdqn.service.impl;

import com.bdqn.entity.Account;
import com.bdqn.mapper.AccountMapper;
import com.bdqn.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.service.impl
 * @Author: RainGrd
 * @CreateTime: 2022-06-15  19:36
 * @Description: TODO
 * @Version: 1.0
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void save(Account account) {
        accountMapper.save(account);
    }

    @Override
    public List<Account> accountFindAll() {
        return accountMapper.accountFindAll();
    }
}
