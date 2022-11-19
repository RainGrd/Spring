package com.bdqn.service.impl;

import com.bdqn.Vo.PageInfo;
import com.bdqn.dao.BookDao;
import com.bdqn.dao.impl.BookDaoImpl;
import com.bdqn.entity.Book;
import com.bdqn.service.BookService;
import com.bdqn.utils.DBUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.service.impl
 * @Author: RainGrd
 * @CreateTime: 2022-07-04  08:57
 * @Description: TODO
 * @Version: 1.0
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public PageInfo<Book> pageAll(int current, int pageSize) {
        return DBUtil.pageList("select * from t_book limit ?,?", Book.class, current, pageSize);
    }

    @Override
    public void add(Book book) {
        List<Object> args = new ArrayList<>();
        args.add(book.getTitle());
        args.add(book.getAuthor());
        args.add(book.getPrice());
        bookDao.add("insert into t_book (id, title, author, price) values (null,?,?,?)", args.toArray());
    }
}
