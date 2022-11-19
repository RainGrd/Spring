package com.itheima.mapper;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author RainGrd
 */
public interface UserMapper {

     List<User> findAll();

     List<User> findUserAndRoleAll();

}
