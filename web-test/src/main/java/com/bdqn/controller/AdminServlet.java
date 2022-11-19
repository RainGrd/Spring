package com.bdqn.controller;

import com.bdqn.entity.Admin;
import com.bdqn.service.AdminService;
import com.bdqn.service.impl.AdminServiceImpl;
import com.bdqn.utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.controller
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  11:04
 * @Description: TODO
 * @Version: 1.0
 */
@WebServlet("/admin/*")
public class AdminServlet extends BaseServlet {

    private AdminService adminService = new AdminServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Admin admin = Util.parsing(Admin.class, request);
        admin = adminService.login(admin.getUsername(), admin.getPassword());
        System.out.println(admin);
        /*存放在session会话中*/
        HttpSession session = request.getSession();
        session.setAttribute("admin", admin);
        /*返回登录成功的标识*/
        response.getWriter().write("loginSuccess");
    }

    public void registered(HttpServletRequest request, HttpServletResponse response) throws IOException,
            ServletException {
        Admin admin = Util.parsing(Admin.class, request);
        System.out.println(admin);
        adminService.registered(admin);
        /*跳转到登录页面*/
        request.setAttribute("registeredMsg", "注册成功！请登录");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    public void forgotPwd(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Admin admin = Util.parsing(Admin.class, request);
        System.out.println(admin);
        adminService.forgotPwd(admin);
        response.getWriter().write("forgotPwdSuccess");
    }
}
