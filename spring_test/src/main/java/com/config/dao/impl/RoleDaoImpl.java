package com.config.dao.impl;

import com.config.dao.RoleDao;
import com.config.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.dao.impl
 * @Author: RainGrd
 * @CreateTime: 2022-06-07  11:36
 * @Description: TODO
 * @Version: 1.0
 */
public class RoleDaoImpl implements RoleDao {
    /**
     * 创建Jdbc模板对象
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Role> queryRoleList() {
        return jdbcTemplate.query("select * from t_role",new BeanPropertyRowMapper<Role>(Role.class));
    }

    @Override
    public <E>List<E> queryAll(Class<E> c, String sql, Object[] args) {
        return jdbcTemplate.query(sql,
                args,
               new BeanPropertyRowMapper<>(c));
    }

    @Override
    public Long queryCount(String sql, Object[] args) {
        return jdbcTemplate.queryForObject(sql, Long.class, args);
    }


    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into t_role values (?,?,?)", null, role.getRoleName(), role.getRoleDesc());
    }



}
