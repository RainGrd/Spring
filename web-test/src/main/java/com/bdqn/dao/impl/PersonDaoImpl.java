package com.bdqn.dao.impl;

import com.bdqn.dao.PersonDao;
import com.bdqn.entity.Person;
import com.bdqn.utils.DBUtil;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.dao.impl
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  11:13
 * @Description: TODO
 * @Version: 1.0
 */
public class PersonDaoImpl implements PersonDao {

    @Override
    public List<Person> personList(String sql) {
        return DBUtil.queryList(Person.class, sql);
    }

    @Override
    public int personTotalCount(String sql) {
        return DBUtil.queryOne(int.class,sql);
    }

    @Override
    public void delete(String sql,int id) {
        DBUtil.update(sql,id);
    }

    @Override
    public void update(String sql,Object[] args) {
          DBUtil.update(sql,args);
    }

    @Override
    public void increase(Object[] args) {
        DBUtil.update("insert t_person values(null,?,?,?,?,?,0)",args);
    }
}
