package com.bdqn.controller;

import com.bdqn.Vo.PageInfo;
import com.bdqn.entity.Book;
import com.bdqn.service.BookService;
import com.bdqn.service.impl.BookServiceImpl;
import com.bdqn.utils.Util;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.controller
 * @Author: RainGrd
 * @CreateTime: 2022-07-04  09:13
 * @Description: TODO
 * @Version: 1.0
 */
@WebServlet("/book/*")
public class BookServlet extends BaseServlet{

    private BookService bookService=new BookServiceImpl();

    /**
     * 查询全部
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int current = Integer.parseInt(request.getParameter("current"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        PageInfo<Book> bookPageInfo = bookService.pageAll(current, pageSize);
        request.setAttribute("bookPageInfo",bookPageInfo.getData());
ObjectMapper mapper=new ObjectMapper();
        System.out.println(bookPageInfo);

        /*请求请发*/
//        request.getRequestDispatcher("/index.jsp").forward(request,response);
        /*会写数据*/
        response.getWriter().write(mapper.writeValueAsString(bookPageInfo));
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getParameter(’)‘
    }
}
