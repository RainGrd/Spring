package com.bdqn.service;

import com.bdqn.entity.Person;
import com.bdqn.utils.PageInfo;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.service
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  11:30
 * @Description: TODO
 * @Version: 1.0
 */
public interface PersonService {
    /**
     * 查询员工
     * @param current 当前页码
     * @param pageSize 最大条数
     * @return com.bdqn.utils.PageInfo
     */
    PageInfo<Person> findPersonList(int current,int pageSize,Person person);

    /**
     * 删除
     * @param id
     */
    void delete(int id);

    /**
     * 修改
     * @param person
     */
    void update(Person person);

    /**
     * 添加员工
     * @param person
     */
    void insert(Person person);
}
