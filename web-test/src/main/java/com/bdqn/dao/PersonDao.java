package com.bdqn.dao;

import com.bdqn.entity.Person;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.dao
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  11:12
 * @Description: TODO
 * @Version: 1.0
 */
public interface PersonDao {
    /**
     * 查询员工
     * @return java.util.List
     */
    List<Person> personList(String sql);

    /**
     * 查询总条目数据
     * @return int
     */
    int personTotalCount(String sql);
    /**
     * 删除
     */
    void delete(String sql,int id);

    /**
     * 修改
     * @param sql
     * @param args
     */
    void update(String sql,Object[] args);

    /**
     * 添加
     * @param args
     */
    void increase(Object[] args);
}
