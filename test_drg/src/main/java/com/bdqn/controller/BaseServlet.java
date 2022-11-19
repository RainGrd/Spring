package com.bdqn.controller;
/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: ${PACKAGE_NAME}
 * @Author: RainGrd
 * @CreateTime: 2022-06-07  11:22
 * @Description: TODO
 * @Version: 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        /*获取请求路径*/
        String uri = request.getRequestURI();
        /*获取最后一个请求路径*/
        int indexOf = uri.lastIndexOf("/");
        /*获取请求方法名称*/
        String methodName = uri.substring(indexOf + 1);
        System.out.println(methodName);
        Class<? extends BaseServlet> aClass = this.getClass();
        try {
            /*获取方法对象*/
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            /*执行方法*/
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
