package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void out(String outMan, double money) {
        jdbcTemplate.update("update t_account set money=money-? where name=?",money,outMan);
    }

    @Override
    public void in(String inMan, double money) {
        jdbcTemplate.update("update t_account set money=money+? where name=?",money,inMan);
    }
}
