package com.bdqn.dao;

import com.bdqn.entity.Book;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.dao
 * @Author: RainGrd
 * @CreateTime: 2022-07-04  08:49
 * @Description: TODO
 * @Version: 1.0
 */
public interface BookDao {
    /**
     * 查询全部
     */
     List<Book> bookList(String sql);
    /**
     * 查询条数
     */
    Long bookTotalCount(String sql);
    /**
     * 添加方法
     */
    void add(String sql,Object[] args);
}
