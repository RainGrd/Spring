package com.bdqn.service;

import com.bdqn.Vo.PageInfo;
import com.bdqn.entity.Book;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.service
 * @Author: RainGrd
 * @CreateTime: 2022-07-04  08:57
 * @Description: TODO
 * @Version: 1.0
 */
public interface BookService {
    /**
     * 查询全部
     *
     * @return
     */
    PageInfo<Book> pageAll(int current,int pageSize);

    /**
     * 添加方法
     */
    void add(Book book);
}
