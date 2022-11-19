package com.config.dao.impl;

import com.config.entity.User;
import com.config.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.dao.impl
 * @Author: RainGrd
 * @CreateTime: 2022-06-09  08:55
 * @Description: TODO
 * @Version: 1.0
 */
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 用于查询用户表
     *
     * @return java.util.List
     */
    @Override
    public List<User> queryUserAll(String sql, Object [] params) {
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),params);
    }

    @Override
    public Long queryCount(String sql, Object[] args) {
        return jdbcTemplate.queryForObject(sql, Long.class, args);
    }

    @Override
    public <E> List<E> queryObject(Long id, Class<E> eClass) {
        return jdbcTemplate.query("select * from t_user_role ur,t_role role where ur.roleId=role.id and ur.userId=?",new BeanPropertyRowMapper<E>(eClass),id);
    }

    @Override
    public Long save(User user) {
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement("insert into t_user values (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPhoneNum());
                preparedStatement.setInt(6, 0);
                return preparedStatement;
            }

        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator,generatedKeyHolder);
        /*获得生成的主键*/
        return generatedKeyHolder.getKey().longValue();
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into t_user_role values(?,?)",userId,roleId);
        }
    }

    @Override
    public void deleteUserById(Long userId) {
        jdbcTemplate.update("update t_user set del_status=1 where id=?",userId);
    }

    @Override
    public User login(String username, String password) throws EmptyResultDataAccessException {
        return  jdbcTemplate.queryForObject("select * from t_user where username=? and password=?", new BeanPropertyRowMapper<User>(User.class),
                username, password);
    }
}
