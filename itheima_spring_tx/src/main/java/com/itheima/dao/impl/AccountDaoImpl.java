package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void out(String outMan, double money) {
        jdbcTemplate.update("update t_account set acc_money=t_account.acc_money-? where acc_name=?",money,outMan);
    }

    @Override
    public void in(String inMan, double money) {
        jdbcTemplate.update("update t_account set acc_money=t_account.acc_money+? where name=?",money,inMan);
    }
}
