package com.system.interceptor;

import com.system.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.interceptor
 * @Author: RainGrd
 * @CreateTime: 2022-06-10  09:49
 * @Description: TODO
 * @Version: 1.0
 */
public class PrivilegeInterceptor implements HandlerInterceptor {

    public String[] allowUrls;

    public void setAllowUrls(String[] allowUrls) {
        this.allowUrls = allowUrls;
    }

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response,
                             @NotNull Object handler) throws Exception {
        /*逻辑：判断用户是否登录 本质：判断session中有没有User对象*/
/*        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user);*/
        //对静态资源放行
        String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
/*        if (null != allowUrls && allowUrls.length >= 1) {
            for (String url : allowUrls) {
                if (requestUrl.contains(url)) {
                    if (user == null) {
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                        return false;
                    }
                    return true;
                }
            }
        }*/
        /*放行*/
        return true;
    }
}
