package com.bdqn.controller;
/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: ${PACKAGE_NAME}
 * @Author: RainGrd
 * @CreateTime: 2022-06-11  17:09
 * @Description: TODO
 * @Version: 1.0
 */

import com.bdqn.entity.User;
import com.bdqn.service.SendMail;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/emailServlet")
public class EmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        ObjectMapper mapper = new ObjectMapper();
        User user=mapper.readValue(request.getReader().readLine(),User.class);
        System.out.println(user);
        SendMail sendMail = new SendMail(user);
        /*开启线程*/
        sendMail.start();
        /*返回数据*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
