package com.bdqn.dao.impl;

import com.bdqn.dao.BookDao;
import com.bdqn.entity.Book;
import com.bdqn.utils.DBUtil;

import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.dao.impl
 * @Author: RainGrd
 * @CreateTime: 2022-07-04  08:49
 * @Description: TODO
 * @Version: 1.0
 */
public class BookDaoImpl implements BookDao {

    @Override
    public List<Book> bookList(String sql) {
        return DBUtil.queryList(Book.class, sql);
    }

    @Override
    public Long bookTotalCount(String sql) {
        return DBUtil.queryOne(Long.class, sql);
    }

    @Override
    public void add(String sql,Object[] args) {
        DBUtil.update(sql,args);
    }
}
