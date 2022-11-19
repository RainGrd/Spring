package com.bdqn.test;

import com.bdqn.Vo.PageInfo;
import com.bdqn.entity.Book;
import com.bdqn.service.BookService;
import com.bdqn.service.impl.BookServiceImpl;
import org.junit.Test;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.test
 * @Author: RainGrd
 * @CreateTime: 2022-07-04  09:01
 * @Description: TODO
 * @Version: 1.0
 */
public class BookServiceTest {

    private BookService bookService=new BookServiceImpl();

    @Test
    public void test1(){
        PageInfo<Book> bookPageInfo = bookService.pageAll(1, 5);
        System.out.println(bookPageInfo);
    }
}
